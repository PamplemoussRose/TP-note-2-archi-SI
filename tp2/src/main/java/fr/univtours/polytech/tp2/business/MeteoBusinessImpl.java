package fr.univtours.polytech.tp2.business;

import fr.univtours.polytech.tp2.dao.MeteoDao;
import fr.univtours.polytech.tp2.model.meteo.WsMeteoResult;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MeteoBusinessImpl implements MeteoBusiness {

    @Inject
    private MeteoDao meteoDao;

    @Override
    public String getMeteo(String lat, String lon) {
        WsMeteoResult res = this.meteoDao.getMeteo(lat, lon);

        String temp = res.getMain().getTemp().toString();
        String humidity = res.getMain().getHumidity().toString();

        String met = "temp :" + temp + "<br> humidity :" + humidity;

        return met;
    }

}
