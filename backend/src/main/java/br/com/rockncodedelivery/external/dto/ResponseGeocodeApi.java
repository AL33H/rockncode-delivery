package br.com.rockncodedelivery.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseGeocodeApi {
    private ArrayList<Result> results;
    private String status;
}


