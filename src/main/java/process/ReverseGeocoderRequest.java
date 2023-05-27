package process;

import model.Geolocation;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReverseGeocoderRequest implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Geolocation geolocation = exchange.getMessage().getBody(Geolocation.class);
        String latitude = Double.toString(geolocation.getLatitude()).trim();
        String longitude = Double.toString(geolocation.getLongitude()).trim();
        exchange.getMessage().setHeader("geolocation", latitude + "," + longitude);
    }
}
