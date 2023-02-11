package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.ResponseGeocodeApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class GoogleAPI {

    @Value("${api.google.key}")
    private String KEY_VALUE;
    @Value("${api.google.base.url}")
    private String BASE_URL;

    private final String constKEY_VALUE = "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU";
    private final String constBASE_URL = "https://maps.googleapis.com/maps/api/geocode/";


    public ResponseGeocodeApi requestToGeocodeApi(String adress) throws RuntimeException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(httpHeaders);

        String URL = constBASE_URL
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

    public void requestToDistanceMatrixApi(String enderecoOrigem, String enderecoFinal){

    }
}
