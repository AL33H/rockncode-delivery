package br.com.rockncodedelivery.external.dto.distanceMatrix;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseDistanceMatrix {
    private ArrayList<String> destination_addresses;
    private ArrayList<String> origin_addresses;
    private ArrayList<Row> rows;
    private String status;
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
class Duration {
    private String text;
    private int value;
}

