package br.com.rockncodedelivery.external.dto.geocode;

import lombok.*;

import java.util.ArrayList;

@Data
public class ResponseGeocodeApi {
    private ArrayList<Result> results;
    private String status;

}

@Data
class Result {
    private ArrayList<AddressComponent> address_components;
    private String formatted_address;
    private Geometry geometry;
    private String place_id;
    private PlusCode plus_code;
    private ArrayList<String> types;
}
@Data
class AddressComponent {
    private String long_name;
    private String short_name;
    private ArrayList<String> types;
}

@Data
class Geometry {
    private Location location;
    private String location_type;
    private Viewport viewport;
}

@Data
class Location {
    private double lat;
    private double lng;
}

@Data
class Viewport {
    private Northeast northeast;
    private Southwest southwest;
}

@Data
class Northeast {
    private double lat;
    private double lng;
}
@Data
class Southwest {
    private double lat;
    private double lng;
}

@Data
class PlusCode {
    private String compound_code;
    private String global_code;
}
