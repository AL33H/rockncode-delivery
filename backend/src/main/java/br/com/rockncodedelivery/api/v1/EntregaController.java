package br.com.rockncodedelivery.api.v1;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.entities.Entrega;
import br.com.rockncodedelivery.domain.service.impl.EntregaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/entrega")
public class EntregaController {

    EntregaServiceImpl entregaService;

    @Autowired
    public EntregaController(EntregaServiceImpl entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega gerarNovaEntrega(@RequestBody EntregaRequest entregaRequest) {
        return entregaService.gerarNovaEntrega(entregaRequest);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Entrega buscarPorId(@PathVariable Long id) {
        return entregaService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Entrega> buscarTodos() {
        return entregaService.buscarTodos();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id){
        entregaService.deletarPorId(id);
    }

}
