package br.com.rockncodedelivery.domain.service;

import br.com.rockncodedelivery.api.v1.dto.EntregadorRequest;
import br.com.rockncodedelivery.api.v1.dto.EntregadorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntregadorService {

    EntregadorResponse criarEntregador(EntregadorRequest entregadorRequest);

    List<EntregadorResponse> listarEntregadores ();

    void deletarEntregador(Long id) throws Exception;
}
