package br.com.rockncodedelivery.external.dto.geocode;

import lombok.Data;

@Data
public class Geometry {
    private Location location;
    private String location_type;
    private Viewport viewport;
}
