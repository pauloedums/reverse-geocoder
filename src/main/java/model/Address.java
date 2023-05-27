package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Address {
    private String amenity;
    private String road;
    private String quarter;
    private String suburb;
    private String city;
    private String municipality;
    private String county;
    private String state_district;
    private String state;
    private String region;
    private String postcode;
    @JsonProperty("ISO3166-2-lvl4")
    private String iso;
    private String country;
    private String country_code;
}
