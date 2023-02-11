package br.com.rockncodedelivery.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntregaRequest {
    private String nomeSolicitante;
    private String enderecoOrigem;
    private String enderecoDestino;
}
