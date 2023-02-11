package br.com.rockncodedelivery.external.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseDistanceMatrix {
    public ArrayList<String> destination_addresses;
    public ArrayList<String> origin_addresses;
    public ArrayList<Row> rows;
    public String status;
}



