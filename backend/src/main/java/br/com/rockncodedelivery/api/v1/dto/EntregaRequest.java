package br.com.rockncodedelivery.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntregaRequest {
    private String NomeSolicitante;
    private String enderecoOrigem;
    private String enderecoDestino;
}
