package br.com.rockncodedelivery;


import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.service.impl.EntregaServiceImpl;
import br.com.rockncodedelivery.external.GoogleAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"br.com.rockncodedelivery.*"})
@EnableJpaRepositories("br.com.rockncodedelivery.*")
public class RockncodedeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RockncodedeliveryApplication.class, args);
        teste();
    }


    public static void teste(String... args) {

//        EntregaServiceImpl entregaService = new EntregaServiceImpl(new GoogleAPI());
//
//        EntregaRequest aleff = new EntregaRequest("Aleff", "63960000", "62960000");
//
//        entregaService.gerarNovaEntrega(aleff);


    }

}
