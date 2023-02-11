package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.directions.ResponseDirectionsApi;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;

public interface ExternalApi {
    ResponseGeocodeApi buscaGeolocalizacaoEndereco(String adress);
    ResponseDistanceMatrix buscaDistanciaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal);
    ResponseDirectionsApi buscaMelhorRotaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal);
}
