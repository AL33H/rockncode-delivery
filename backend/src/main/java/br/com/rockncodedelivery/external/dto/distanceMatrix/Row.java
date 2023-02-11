package br.com.rockncodedelivery.external.dto.distanceMatrix;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Row {
    private ArrayList<Element> elements;
}
