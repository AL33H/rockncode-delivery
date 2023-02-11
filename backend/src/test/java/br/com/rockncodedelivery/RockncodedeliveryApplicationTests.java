package br.com.rockncodedelivery;

import br.com.rockncodedelivery.domain.service.impl.EntregaServiceImpl;
import br.com.rockncodedelivery.external.GoogleAPI;
import br.com.rockncodedelivery.external.dto.geocode.ResponseGeocodeApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.net.http.HttpClient;

@SpringBootTest
class RockncodedeliveryApplicationTests {

	@Autowired
	private GoogleAPI googleAPI;

	@Autowired
	private EntregaServiceImpl entregaService;

	@Test
	void contextLoads() {
	}

	@Test
	void TesteApiGeolocalizacao(){
		ResponseGeocodeApi tabuleiroDoNorte = googleAPI.buscaGeolocalizacaoEndereco("Tabuleiro do Norte");
		Assert.hasText("Tabuleiro do Norte");
		Assert.hasText(tabuleiroDoNorte.getStatus(), HttpStatus.OK.toString());
	}

	@Test
	void testarSelectStatusCriado(){
		System.out.println(entregaService.buscarPorStatus("CRIADO"));
	}


}
