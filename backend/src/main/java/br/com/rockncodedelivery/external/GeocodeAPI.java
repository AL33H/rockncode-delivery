package br.com.rockncodedelivery.external;

import br.com.rockncodedelivery.external.dto.ResponseGeocodeApi;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

public class GeocodeAPI {

    private final RestTemplate restTemplate;

    public GeocodeAPI(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseGeocodeApi requestToGeocodeApi(String adress) {
        

        restTemplate.getForEntity();


        return null;
    }
}
