package br.com.rockncodedelivery.external.dto.distanceMatrix;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseDistanceMatrix {
    public ArrayList<String> destination_addresses;
    public ArrayList<String> origin_addresses;
    public ArrayList<Row> rows;
    public String status;
}

@Data
class Row {
    private ArrayList<Element> elements;
}

@Data
class EntregadorResponse {

    private String nome;
    private Integer avaliacao;
    private String placa;
}


@Data
class EntregadorRequest {

    private String nome;
    private String placa;
}

@Data
class Element {
    private Distance distance;
    private Duration duration;
    private String status;
}

@Data
class Duration {
    private String text;
    private int value;
}

@Data
class Distance {
    private String text;
    private int value;
}
