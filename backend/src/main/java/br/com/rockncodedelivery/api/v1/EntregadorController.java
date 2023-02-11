package br.com.rockncodedelivery.api.v1;

import br.com.rockncodedelivery.api.v1.dto.EntregadorRequest;
import br.com.rockncodedelivery.api.v1.dto.EntregadorResponse;
import br.com.rockncodedelivery.domain.service.impl.EntregadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/entregador")
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEntregador(@PathVariable Long id) throws Exception {
        entregadorService.deletarEntregador(id);
    }

    @GetMapping("/{id}")
    public void buscarPorId(@PathVariable Long id) {
        entregadorService.buscarPorId(id);
    }
}
