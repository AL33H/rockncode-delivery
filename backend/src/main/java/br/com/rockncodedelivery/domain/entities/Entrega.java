package br.com.rockncodedelivery.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Builder
@Getter
@ToString
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomeSolicitante;
    @OneToOne
    private Entregador entregador;
    @Embedded
    private LocalizacaoOrigem enderecoOrigem;
    @Embedded
    private LocalizacaoDestino enderecoDestino;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private StatusEntrega Status = StatusEntrega.CRIADO;

    public Entrega() {
    }

    public Entrega(Long id, String nomeSolicitante, Entregador entregador, LocalizacaoOrigem enderecoOrigem, LocalizacaoDestino enderecoDestino, Double valor, StatusEntrega status) {
        this.id = id;
        this.nomeSolicitante = nomeSolicitante;
        this.entregador = entregador;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.valor = valor;
        Status = StatusEntrega.CRIADO;
    }

    public void proximoStatus() {
        switch (this.Status) {
            case CRIADO:
                this.Status = StatusEntrega.EMANDAMENTO;
                break;
            case EMANDAMENTO:
                this.Status = StatusEntrega.CONCLUIDO;
                break;
        }
    }


    public void calcularValor(Double km){
        this.valor = km * 1;
    }

    //TODO
    //DEFINIR REGRAS PARA STATUS

    //DEFINIR REGRAS PARA PARSE GENERIC DTO.

    //DEFINIR REGRAS PARA CALCULO DE VALOR

}


