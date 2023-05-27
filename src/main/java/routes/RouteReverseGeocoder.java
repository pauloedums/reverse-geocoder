package routes;

import model.Geolocation;
import model.ReverseGeocoder;
import org.apache.camel.Exchange;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import process.ReverseGeocoderRequest;
import process.ReverseGeocoderResponse;


public class RouteReverseGeocoder extends RouteBuilder {

    @PropertyInject("geolocation.serverUrl")
    private String geolocationUrl;
    @PropertyInject("geolocation.type")
    private String geolocationType;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .port(8080)
                .bindingMode(RestBindingMode.json);

        rest("/reverse-geocoder")
                .consumes("application/json")
                .produces("application/json")
                .post("/location")
                .description("Find your address by latitude and longitude")
                .type(Geolocation.class)
                .routeId("reverseGeocoder")

                .to("direct:start");

        from("direct:start")
                .routeId("start")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .process(new ReverseGeocoderRequest())
                .toD("geocoder:latlng:${header.geolocation}?type="+geolocationType+"&serverUrl="+geolocationUrl)
                .unmarshal().json(ReverseGeocoder.class)
                .process(new ReverseGeocoderResponse())
                .removeHeaders("*")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .end();
    }
}
