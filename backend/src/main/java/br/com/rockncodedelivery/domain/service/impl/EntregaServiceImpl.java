package br.com.rockncodedelivery.domain.service.impl;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.api.v1.dto.EntregadorResponse;
import br.com.rockncodedelivery.domain.entities.*;
import br.com.rockncodedelivery.domain.repository.EntregaRepository;
import br.com.rockncodedelivery.domain.service.EntregaService;
import br.com.rockncodedelivery.external.ExternalApi;
import br.com.rockncodedelivery.external.GoogleAPI;
import br.com.rockncodedelivery.external.dto.directions.ResponseDirectionsApi;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private ModelMapper modelMapper;

    private ExternalApi externalApi;

    private EntregaRepository entregaRepository;

    private EntregadorServiceImpl entregadorService;

    @Autowired
    public EntregaServiceImpl(GoogleAPI externalApi, EntregaRepository entregaRepository, EntregadorServiceImpl entregadorService) {
        this.externalApi = externalApi;
        this.entregaRepository = entregaRepository;
        this.entregadorService = entregadorService;
    }

    public Entrega gerarNovaEntrega(EntregaRequest entregaRequest) {

        ResponseGeocodeApi geocodeOrigem = externalApi.buscaGeolocalizacaoEndereco(entregaRequest.getEnderecoOrigem());
        ResponseGeocodeApi geocodeDestino = externalApi.buscaGeolocalizacaoEndereco(entregaRequest.getEnderecoDestino());

        LocalizacaoOrigem localizacaoOrigem = new LocalizacaoOrigem(
                geocodeOrigem.getResults().get(0).getGeometry().getLocation().getLat(),
                geocodeOrigem.getResults().get(0).getGeometry().getLocation().getLng());

        LocalizacaoDestino localizacaoDestino = new LocalizacaoDestino(
                geocodeDestino.getResults().get(0).getGeometry().getLocation().getLat(),
                geocodeDestino.getResults().get(0).getGeometry().getLocation().getLng());

        ResponseDistanceMatrix responseDistanceMatrix = externalApi.buscaDistanciaEntreDoisEnderecos(
                entregaRequest.getEnderecoOrigem(),
                entregaRequest.getEnderecoDestino());

        String text = responseDistanceMatrix.getRows().get(0).getElements().get(0).getDistance().getText()
                .replace("km", "")
                .replace("m", "")
                .replace(" ", "");

        Entrega entrega = Entrega.builder()
                .nomeSolicitante(entregaRequest.getNomeSolicitante())
                .enderecoOrigem(localizacaoOrigem)
                .enderecoDestino(localizacaoDestino)
                .valor(Double.valueOf(text))
                .build();

        System.out.println(entrega);

        return entregaRepository.save(entrega);
    }

    public Entrega buscarPorId(Long id) {
        Optional<Entrega> entrega = entregaRepository.findById(id);
        return entrega.orElseThrow(IllegalStateException::new);
    }

    public List<Entrega> buscarTodos() {
        return entregaRepository.findAll();
    }

    public void deletarPorId(Long id) {
        entregaRepository.deleteById(id);
    }

    public List<Entrega> buscarPorStatus(String status) {
        StatusEntrega statusEntrega = StatusEntrega.valueOf(status);
        return entregaRepository.findByStatus(statusEntrega);
    }

    public ResponseDirectionsApi obterMelhorRota(String enderecoOrigem, String enderecoFinal) {
        return externalApi.buscaMelhorRotaEntreDoisEnderecos(enderecoOrigem, enderecoOrigem);
    }

    public void vincularEntregadorAEntrega(Long idEntregador, Long idEntrega) {
        Entrega entrega = this.buscarPorId(idEntrega);
        EntregadorResponse entregadorResponse = entregadorService.buscarPorId(idEntregador);
        Entregador entregador = modelMapper.map(entregadorResponse, Entregador.class);
        entrega.setEntregador(entregador);
        entregaRepository.save(entrega);
    }


    public boolean proximoStatus(Long idEntrega) {
        Entrega entrega = buscarPorId(idEntrega);
        if (entrega.proximoStatus()) {
            entregaRepository.save(entrega);
            return true;
        } else {
            return false;
        }
    }
}
