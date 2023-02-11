package br.com.rockncodedelivery.domain.entities;


import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Localizacao {
    private String latitude;
    private String longitude;
}
