package model;

import lombok.Getter;

@Getter
public class ReverseGeocoder {
    private Double place_id;
    private String licence;
    private String osm_type;
    private Double osm_id;
    private String lat;
    private String lon;
    private Integer place_rank;
    private String category;
    private String type;
    private Integer importance;
    private String addresstype;
    private String name;
    private String display_name;
    private Address address;
    private String[] boundingbox;
}
