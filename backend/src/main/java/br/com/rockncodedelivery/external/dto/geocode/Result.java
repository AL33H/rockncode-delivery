package br.com.rockncodedelivery.external.dto.geocode;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Result {
    private ArrayList<AddressComponent> address_components;
    private String formatted_address;
    private Geometry geometry;
    private String place_id;
    private PlusCode plus_code;
    private ArrayList<String> types;
}
