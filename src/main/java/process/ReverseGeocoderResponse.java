package process;

import model.Address;
import model.ReverseGeocoder;
import model.ReserveGeocoderRes;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class ReverseGeocoderResponse implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        ReverseGeocoder reserveGeocoder = exchange.getMessage().getBody(ReverseGeocoder.class);
        Address address = reserveGeocoder.getAddress();
        ReserveGeocoderRes reserveGeocoderRes = ReserveGeocoderRes
                .builder()
                    .lat(reserveGeocoder.getLat())
                    .lon(reserveGeocoder.getLon())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .regionName(address.getRegion())
                    .address(reserveGeocoder.getDisplay_name())
                    .suburb(address.getSuburb())
                    .quarter(address.getQuarter())
                .build();
        exchange.getIn().setBody(reserveGeocoderRes);
    }
}
