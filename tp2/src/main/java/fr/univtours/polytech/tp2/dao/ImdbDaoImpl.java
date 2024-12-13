package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.film.Description;
import fr.univtours.polytech.tp2.model.film.WsFilmResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class ImdbDaoImpl implements ImdbDao{

    private static final String URI = "https://imdb.iamidiotareyoutoo.com/search?"; 

    @Override
    public List<Description> getFilms(String search) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(URI)
        .queryParam("q", search);

        WsFilmResult wsResult = target.request(MediaType.APPLICATION_JSON).get(WsFilmResult.class);
        return wsResult.getDescription();
    }

}
