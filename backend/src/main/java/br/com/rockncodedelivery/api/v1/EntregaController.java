package br.com.rockncodedelivery.api.v1;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.entities.Entrega;
import br.com.rockncodedelivery.domain.service.impl.EntregaServiceImpl;
import br.com.rockncodedelivery.external.dto.directions.ResponseDirectionsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/entrega")
@CrossOrigin(origins = "http://localhost:3000/")
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
    public void deletarPorId(@PathVariable Long id) {
        entregaService.deletarPorId(id);
    }

    @GetMapping("rotas/")
    public ResponseDirectionsApi obterMelhorRota(@RequestParam("enderecoOrigem") String enderecoOrigem, @RequestParam("enderecoFinal") String enderecoFinal) {
        return entregaService.obterMelhorRota(enderecoOrigem, enderecoFinal);
    }

    @PutMapping("vincular/")
    public void vincularEntregadorAEntrega(@RequestParam("idEntregador") Long idEntregador, @RequestParam("idEntrega") Long idEntrega) {
        entregaService.vincularEntregadorAEntrega(idEntregador, idEntrega);
    }

    @PutMapping("{idEntrega}")
    public ResponseEntity<Void> proximoStatus(@PathVariable Long idEntrega) {
        if(entregaService.proximoStatus(idEntrega)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
