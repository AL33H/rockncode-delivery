package br.com.rockncodedelivery;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"br.com.rockncodedelivery.*"})
@EnableJpaRepositories("br.com.rockncodedelivery.*")
public class RockncodedeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RockncodedeliveryApplication.class, args);
    }
}
