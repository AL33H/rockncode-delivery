package br.com.rockncodedelivery.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDestino {
    private Double latitudeDestino;
    private Double longitudeDestino;

}
