package br.com.rockncodedelivery.api.v1;

import br.com.rockncodedelivery.api.v1.dto.EntregaRequest;
import br.com.rockncodedelivery.domain.entities.Entrega;
import br.com.rockncodedelivery.domain.service.impl.EntregaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/entrega")
public class EntregaController {

    @Autowired
    EntregaServiceImpl entregaService;

    @PostMapping
    public Entrega gerarNovaEntrega(@RequestBody EntregaRequest entregaRequest) {
        return entregaService.gerarNovaEntrega(entregaRequest);
    }

}
