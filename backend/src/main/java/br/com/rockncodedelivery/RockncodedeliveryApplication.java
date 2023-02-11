package br.com.rockncodedelivery;

import br.com.rockncodedelivery.external.GeocodeAPI;
import br.com.rockncodedelivery.external.dto.ResponseGeocodeApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.rockncodedelivery.*"})
public class RockncodedeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RockncodedeliveryApplication.class, args);
        teste();
    }


    public static void teste(String... args) {

        System.out.println("TESTE");
        GeocodeAPI geocodeAPI = new GeocodeAPI();
        ResponseGeocodeApi responseGeocodeApi = geocodeAPI.requestToGeocodeApi("baixo%2guandu%2espirito%2santo");
        System.out.println(responseGeocodeApi.toString());

    }

}
