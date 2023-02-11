package br.com.rockncodedelivery.domain.entities;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomeSolicitante;
    @OneToOne
    private Entregador entregador;
    @Embedded
    private Localizacao enderecoOrigem;
    @Embedded
    private Localizacao enderecoFinal;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private StatusEntrega Status = StatusEntrega.CRIADO;

    public Entrega() {
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


