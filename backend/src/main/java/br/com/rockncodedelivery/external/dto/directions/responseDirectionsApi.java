package br.com.rockncodedelivery.external.dto.directions;

import lombok.Data;

import java.util.ArrayList;

@Data
public class responseDirectionsApi {
    public ArrayList<GeocodedWaypoint> geocoded_waypoints;
    public ArrayList<Route> routes;
    public String status;
}

@Data
class Bounds {
    public Northeast northeast;
    public Southwest southwest;
}

@Data
class Distance {
    public String text;
    public int value;
}

@Data
class Duration {
    public String text;
    public int value;
}

@Data
class EndLocation {
    public double lat;
    public double lng;
}

@Data
class GeocodedWaypoint {
    public String geocoder_status;
    public String place_id;
    public ArrayList<String> types;
}

@Data
class Leg {
    public Distance distance;
    public Duration duration;
    public String end_address;
    public EndLocation end_location;
    public String start_address;
    public StartLocation start_location;
    public ArrayList<Step> steps;
    public ArrayList<Object> traffic_speed_entry;
    public ArrayList<Object> via_waypoint;
}

@Data
class Northeast {
    public double lat;
    public double lng;
}

@Data
class OverviewPolyline {
    public String points;
}

@Data
class Polyline {
    public String points;
}

@Data
class Route {
    public Bounds bounds;
    public String copyrights;
    public ArrayList<Leg> legs;
    public OverviewPolyline overview_polyline;
    public String summary;
    public ArrayList<Object> warnings;
    public ArrayList<Object> waypoint_order;
}

@Data
class Southwest {
    public double lat;
    public double lng;
}

@Data
class StartLocation {
    public double lat;
    public double lng;
}

@Data
class Step {
    public Distance distance;
    public Duration duration;
    public EndLocation end_location;
    public String html_instructions;
    public Polyline polyline;
    public StartLocation start_location;
    public String travel_mode;
    public String maneuver;
}

