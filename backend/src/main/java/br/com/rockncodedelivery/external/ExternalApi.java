package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.directions.ResponseDirectionsApi;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import br.com.rockncodedelivery.external.dto.places.ResponsePlacesApi;

public interface ExternalApi {
    ResponseGeocodeApi buscaGeolocalizacaoEndereco(String adress);
    ResponseDistanceMatrix buscaDistanciaEntreDoisEnderecos(String enderecoOrigem, String enderecoDestino);
    ResponseDirectionsApi buscaMelhorRotaEntreDoisEnderecos(String enderecoOrigem, String enderecoDestino);
    ResponsePlacesApi buscaReferenciasNoEnderecoFinal(String enderecoFinal);
}
