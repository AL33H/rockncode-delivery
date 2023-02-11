package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.directions.ResponseDirectionsApi;
import br.com.rockncodedelivery.external.dto.distanceMatrix.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import br.com.rockncodedelivery.external.dto.places.ResponsePlacesApi;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
@Service
public class GoogleAPI implements ExternalApi {

    @Value("${api.google.key}")
    private String KEY_VALUE;
    @Value("${api.google.base.url.geocode}")
    private String BASE_URL_GEOCODE;

    @Value("${api.google.base.url.distancematrix}")
    private String BASE_URL_DISTANCEMATRIX;

    @Value("${api.google.base.url.directions}")
    private String BASE_URL_DIRECTIONS;

    @Value("${api.google.base.url.place}")
    private String BASE_URL_PLACE;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseGeocodeApi buscaGeolocalizacaoEndereco(String adress) throws RuntimeException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = BASE_URL_GEOCODE
                .concat("json?")
                .concat("address=" + adress)
                .concat("&key=" + KEY_VALUE);

        ResponseEntity<ResponseGeocodeApi> exchange = restTemplate
                .exchange(URL, HttpMethod.POST, objectHttpEntity, ResponseGeocodeApi.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }

    @Override
    public ResponseDistanceMatrix buscaDistanciaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = BASE_URL_DISTANCEMATRIX
                .concat("json?")
                .concat("origins=" + enderecoOrigem)
                .concat("&destinations=" + enderecoFinal)
                .concat("&key=" + KEY_VALUE);
        ResponseEntity<ResponseDistanceMatrix> exchange = restTemplate
                .exchange(URL, HttpMethod.GET, objectHttpEntity, ResponseDistanceMatrix.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }

    @Override
    public ResponseDirectionsApi buscaMelhorRotaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = BASE_URL_DIRECTIONS
                .concat("json?")
                .concat("origin=" + enderecoOrigem)
                .concat("&destination=" + enderecoFinal)
                .concat("&key=" + KEY_VALUE);
        ResponseEntity<ResponseDirectionsApi> exchange = restTemplate
                .exchange(URL, HttpMethod.GET, objectHttpEntity, ResponseDirectionsApi.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }

    @Override
    public ResponsePlacesApi buscaReferenciasNoEnderecoFinal(String enderecoFinal) {


        ResponseGeocodeApi responseGeocodeApi = buscaGeolocalizacaoEndereco(enderecoFinal);
        Double latitude = responseGeocodeApi.getResults().get(0).getGeometry().getLocation().getLng();
        Double longitude = responseGeocodeApi.getResults().get(0).getGeometry().getLocation().getLat();


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = BASE_URL_DIRECTIONS
                .concat("json?")
                .concat("location=" + latitude +"2%2C"+ longitude)
                .concat("&radius=" + 500)
                .concat("&key=" + KEY_VALUE);
        ResponseEntity<ResponsePlacesApi> exchange = restTemplate
                .exchange(URL, HttpMethod.GET, objectHttpEntity, ResponsePlacesApi.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }



    //https://maps.googleapis.com/maps/api/directions/json?destination=Voltex, Av. Giustiniano Borin, 3215 - Jardim Caxambu, Jundiaí - SP, 13218-546&origin=Av. Silvestre José de Oliveira, 841 - Jardim Caxambu, Jundiaí - SP, 13218-662&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU
}
