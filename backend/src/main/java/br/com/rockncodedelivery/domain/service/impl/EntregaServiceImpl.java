package br.com.rockncodedelivery.domain.service.impl;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.entities.Entrega;
import br.com.rockncodedelivery.domain.entities.Localizacao;
import br.com.rockncodedelivery.domain.service.EntregaService;
import br.com.rockncodedelivery.external.ExternalApi;
import br.com.rockncodedelivery.external.dto.distanceMatrix.Element;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import br.com.rockncodedelivery.external.dto.geocode.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private ExternalApi externalApi;

    public void gerarNovaEntrega(EntregaRequest entregaRequest) {

        ResponseGeocodeApi geocodeOrigem = externalApi.buscaGeolocalizacaoEndereco(entregaRequest.getEnderecoOrigem());
        ResponseGeocodeApi geocodeDestino = externalApi.buscaGeolocalizacaoEndereco(entregaRequest.getEnderecoDestino());


        Localizacao localizacaoOrigem = new Localizacao(
                geocodeOrigem.getResults().get(0).getGeometry().getLocation().getLat(),
                geocodeOrigem.getResults().get(0).getGeometry().getLocation().getLng());

        Localizacao localizacaoDestino = new Localizacao(
                geocodeDestino.getResults().get(0).getGeometry().getLocation().getLat(),
                geocodeDestino.getResults().get(0).getGeometry().getLocation().getLng());

        ResponseDistanceMatrix responseDistanceMatrix = externalApi.buscaDistanciaEntreDoisEnderecos(
                entregaRequest.getEnderecoOrigem(),
                entregaRequest.getEnderecoDestino());

        String text = responseDistanceMatrix.getRows().get(0).getElements().get(0).getDistance().getText();

        Entrega entrega = Entrega.builder()
                .nomeSolicitante(entregaRequest.getNomeSolicitante())
                .enderecoOrigem(localizacaoOrigem)
                .enderecoDestino(localizacaoDestino)
                .valor(Double.valueOf(text))
                .build();


        System.out.println(entrega);

    }


    //todo
    //new
    //getAll(Receber enum)
    //delete


}
