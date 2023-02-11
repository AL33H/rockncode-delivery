package br.com.rockncodedelivery.api.v1.dto;


import lombok.Data;

@Data
public class EntregaRequest {
    private String NomeSolicitante;
    private String enderecoOrigem;
    private String enderecoDestino;
}
