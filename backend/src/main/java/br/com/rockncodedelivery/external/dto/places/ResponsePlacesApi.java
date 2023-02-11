package br.com.rockncodedelivery.external.dto.places;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponsePlacesApi {
    public ArrayList<Object> html_attributions;
    public String next_page_token;
    public ArrayList<Result> results;
    public String status;
}
@Data
class Geometry {
    public Location location;
    public Viewport viewport;
}
@Data
class Location {
    public double lat;
    public double lng;
}
@Data
class Northeast {
    public double lat;
    public double lng;
}
@Data
class OpeningHours {
    public boolean open_now;
}
@Data
class Photo {
    public int height;
    public ArrayList<String> html_attributions;
    public String photo_reference;
    public int width;
}
@Data
class PlusCode {
    public String compound_code;
    public String global_code;
}
@Data
class Result {
    public Geometry geometry;
    public String icon;
    public String icon_background_color;
    public String icon_mask_base_uri;
    public String name;
    public String place_id;
    public String reference;
    public String scope;
    public ArrayList<String> types;
    public String vicinity;
    public String business_status;
    public OpeningHours opening_hours;
    public ArrayList<Photo> photos;
    public PlusCode plus_code;
    public int price_level;
    public double rating;
    public int user_ratings_total;
    public boolean permanently_closed;
}

@Data
class Southwest {
    public double lat;
    public double lng;
}
@Data
class Viewport {
    public Northeast northeast;
    public Southwest southwest;
}

