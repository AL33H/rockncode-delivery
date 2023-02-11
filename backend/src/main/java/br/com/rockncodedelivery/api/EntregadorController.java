package br.com.rockncodedelivery.api;

import br.com.rockncodedelivery.domain.entities.Entregador;
import br.com.rockncodedelivery.domain.repository.EntregadorRepository;
import br.com.rockncodedelivery.domain.service.impl.EntregadorServiceImpl;
import br.com.rockncodedelivery.external.dto.EntregadorRequest;
import br.com.rockncodedelivery.external.dto.EntregadorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class EntregadorController {

    @Autowired
    private EntregadorServiceImpl entregadorService;

    @PostMapping
    public EntregadorResponse criarEntregador(@Validated @RequestBody EntregadorRequest entregadorRequest) {

        EntregadorResponse entregadorSalvo = entregadorService.criarEntregador(entregadorRequest);
        return entregadorSalvo;
    }

    @GetMapping
    public List<EntregadorResponse> listarEntregadores() {
        return entregadorService.listarEntregadores();
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEntregador(@PathVariable Long id) throws Exception {
        entregadorService.deletarEntregador(id);
    }
}
