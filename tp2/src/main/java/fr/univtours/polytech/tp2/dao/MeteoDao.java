package fr.univtours.polytech.tp2.dao;

import fr.univtours.polytech.tp2.model.meteo.WsMeteoResult;

public interface MeteoDao {

    public WsMeteoResult getMeteo(String lat, String lon);

}
