package br.com.rockncodedelivery.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusEntrega {
    CRIADO(1L, "CRIADO"),
    EMANDAMENTO(2L , "EMANDAMENTO"),
    CONCLUIDO(3L ,"CONCLUIDO");

    @Getter
    private Long id;

    @Getter
    private String descricao;
}
