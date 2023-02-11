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

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private GoogleAPI externalApi;

    @Autowired
    private EntregaRepository entregaRepository;

    public EntregaServiceImpl(GoogleAPI externalApi) {
        this.externalApi = externalApi;
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
                .replace(" ","")
                .replace("m","");


        Entrega entrega = Entrega.builder()
                .nomeSolicitante(entregaRequest.getNomeSolicitante())
                .enderecoOrigem(localizacaoOrigem)
                .enderecoDestino(localizacaoDestino)
                .valor(Double.valueOf(text))
                .build();

        System.out.println(entrega);

        return entregaRepository.save(entrega);
        
    }


    //todo
    //new
    //getAll(Receber enum)
    //delete


}
