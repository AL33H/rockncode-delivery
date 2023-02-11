package br.com.rockncodedelivery;


import br.com.rockncodedelivery.external.GoogleAPI;
import br.com.rockncodedelivery.external.dto.directions.responseDirectionsApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.rockncodedelivery.*"})
public class RockncodedeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RockncodedeliveryApplication.class, args);
        teste();
    }


    public static void teste(String... args) {

        GoogleAPI geocodeAPI = new GoogleAPI();
//        ResponseGeocodeApi responseGeocodeApi = geocodeAPI.requestToGeocodeApi("baixo%2guandu%2espirito%2santo");
//        System.out.println(responseGeocodeApi.toString());
        responseDirectionsApi responseDirectionsApi = geocodeAPI
                .buscaMelhorRotaEntreDoisEnderecos("62960000", "63960000");
        System.out.println(responseDirectionsApi.toString());

    }

}
