package br.com.rockncodedelivery.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
    @Setter
    private Entregador entregador;
    @Embedded
    private LocalizacaoOrigem enderecoOrigem;
    @Embedded
    private LocalizacaoDestino enderecoDestino;
    private Double valor;
    @Enumerated(EnumType.ORDINAL)
    private StatusEntrega status = StatusEntrega.CRIADO;

    public Entrega() {
    }

    public Entrega(Long id, String nomeSolicitante, Entregador entregador, LocalizacaoOrigem enderecoOrigem, LocalizacaoDestino enderecoDestino, Double valor, StatusEntrega status) {
        this.id = id;
        this.nomeSolicitante = nomeSolicitante;
        this.entregador = entregador;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.valor = valor;
        this.status = StatusEntrega.CRIADO;
    }

    public boolean proximoStatus() {
        if (entregador != null) {
            switch (this.status) {
                case CRIADO:
                    this.status = StatusEntrega.EMANDAMENTO;
                    break;
                case EMANDAMENTO:
                    this.status = StatusEntrega.CONCLUIDO;
                    break;
            }
        } else {
            return false;
        }
        return true;
    }


    public void calcularValor(Double km) {
        this.valor = km * 1;
    }

    //TODO
    //DEFINIR REGRAS PARA STATUS

    //DEFINIR REGRAS PARA PARSE GENERIC DTO.

    //DEFINIR REGRAS PARA CALCULO DE VALOR

}


