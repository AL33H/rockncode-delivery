package br.com.rockncodedelivery.domain.service.impl;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.entities.Entrega;
import br.com.rockncodedelivery.domain.entities.LocalizacaoDestino;
import br.com.rockncodedelivery.domain.entities.LocalizacaoOrigem;
import br.com.rockncodedelivery.domain.repository.EntregaRepository;
import br.com.rockncodedelivery.domain.service.EntregaService;
import br.com.rockncodedelivery.external.ExternalApi;
import br.com.rockncodedelivery.external.GoogleAPI;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    private ExternalApi externalApi;

    private EntregaRepository entregaRepository;
    @Autowired
    public EntregaServiceImpl(GoogleAPI externalApi, EntregaRepository entregaRepository) {
        this.externalApi = externalApi;
        this.entregaRepository = entregaRepository;
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

    public Entrega buscarPorId(@RequestParam(value = "id") Long id) {
        Optional<Entrega> entrega = entregaRepository.findById(id);
        return entrega.orElseThrow(IllegalStateException::new);
    }

    public List<Entrega> buscarTodos(){
        return entregaRepository.findAll();
    }

    public void deletarPorId(@RequestParam(value = "id") Long id){
        entregaRepository.deleteById(id);
    }
}
