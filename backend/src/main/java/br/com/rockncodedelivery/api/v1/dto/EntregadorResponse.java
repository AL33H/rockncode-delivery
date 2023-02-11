package br.com.rockncodedelivery.api.v1.dto;

import lombok.Data;

@Data
public class EntregadorResponse {

    private Long id;
    private String nome;
    private Integer avaliacao;
    private String placa;
}
