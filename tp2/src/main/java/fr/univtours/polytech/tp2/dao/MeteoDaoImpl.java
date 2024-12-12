package fr.univtours.polytech.tp2.dao;

import fr.univtours.polytech.tp2.model.meteo.WsMeteoResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class MeteoDaoImpl implements MeteoDao {

    private static String URI = "https://api.openweathermap.org/data/2.5/weather?appid=215b3059d14f2008dc8ab3483f9a4310";

    @Override
    public WsMeteoResult getMeteo(String lat, String lon) {
        Client client = ClientBuilder.newClient();

        WsMeteoResult result = client.target(URI)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .request(MediaType.APPLICATION_JSON)
                .get(WsMeteoResult.class);
        return result;
    }
}
