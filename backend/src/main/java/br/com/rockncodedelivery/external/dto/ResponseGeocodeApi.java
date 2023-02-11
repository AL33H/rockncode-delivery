package br.com.rockncodedelivery.external.dto;

import lombok.*;

import java.util.ArrayList;

@Data
public class ResponseGeocodeApi {
    private ArrayList<Result> results;
    private String status;

}


