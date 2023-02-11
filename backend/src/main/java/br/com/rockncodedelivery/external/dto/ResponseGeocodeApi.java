package br.com.rockncodedelivery.external.dto;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseGeocodeApi {
    private ArrayList<Result> results;
    private String status;


}


