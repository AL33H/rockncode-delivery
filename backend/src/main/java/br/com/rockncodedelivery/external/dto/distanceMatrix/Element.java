package br.com.rockncodedelivery.external.dto.distanceMatrix;

import lombok.Data;

@Data
public class Element {
    private Distance distance;
    private Duration duration;
    private String status;
}
