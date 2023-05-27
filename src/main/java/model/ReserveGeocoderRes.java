package model;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Builder
public class ReserveGeocoderRes {
    private String lat;
    private String lon;
    private String regionName;
    private String address;
    private String city;
    private String country;
    private String suburb;
    private String quarter;
}
