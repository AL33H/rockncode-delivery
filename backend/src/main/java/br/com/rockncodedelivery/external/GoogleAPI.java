package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.ResponseDistanceMatrix;
import br.com.rockncodedelivery.external.dto.ResponseGeocodeApi;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
public class GoogleAPI {

    @Value("${api.google.key}")
    private String KEY_VALUE;
    @Value("${api.google.base.url}")
    private String BASE_URL;

    RestTemplate restTemplate = new RestTemplate();

    private final String constKEY_VALUE = "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU";
    private final String constBASE_URL_GEOCODE = "https://maps.googleapis.com/maps/api/geocode/";
    private final String constBASE_URL_DISTANCEMATRIX = "https://maps.googleapis.com/maps/api/distancematrix/";
    private final String constBASE_URL_DIRECTIONS = "https://maps.googleapis.com/maps/api/directions/";


    public ResponseGeocodeApi buscaGeolocalizacaoEndereco(String adress) throws RuntimeException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL =  constBASE_URL_GEOCODE
                .concat("json?")
                .concat("address=" + adress)
                .concat("&key=" + constKEY_VALUE);

        ResponseEntity<ResponseGeocodeApi> exchange = restTemplate
                .exchange(URL, HttpMethod.POST, objectHttpEntity, ResponseGeocodeApi.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }

    public ResponseDistanceMatrix buscaDistanciaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = constBASE_URL_DISTANCEMATRIX
                .concat("json?")
                .concat("origins=" + enderecoOrigem)
                .concat("&destinations=" + enderecoFinal)
                .concat("&key=" + constKEY_VALUE);
        ResponseEntity<ResponseDistanceMatrix> exchange = restTemplate
                .exchange(URL, HttpMethod.GET, objectHttpEntity, ResponseDistanceMatrix.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }
    public ResponseDistanceMatrix buscaMelhorRotaEntreDoisEnderecos(String enderecoOrigem, String enderecoFinal) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = constBASE_URL_DISTANCEMATRIX
                .concat("json?")
                .concat("origins=" + enderecoOrigem)
                .concat("&destinations=" + enderecoFinal)
                .concat("&key=" + constKEY_VALUE);
        ResponseEntity<ResponseDistanceMatrix> exchange = restTemplate
                .exchange(URL, HttpMethod.GET, objectHttpEntity, ResponseDistanceMatrix.class);

        if (exchange.getStatusCode() != HttpStatus.OK ||
                exchange.getBody().getStatus().equals("REQUEST_DENIED")) {

            throw new RuntimeException("Erro ao requisitar no google Api.");

        }

        return exchange.getBody();
    }
}
