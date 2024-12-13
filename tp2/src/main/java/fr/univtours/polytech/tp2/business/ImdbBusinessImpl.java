package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.dao.ImdbDao;
import fr.univtours.polytech.tp2.model.film.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ImdbBusinessImpl implements ImdbBusiness {

    @Inject
    private ImdbDao imdbDao;

    @Override
    public List<Description> getFilms(String title) {
        return this.imdbDao.getFilms(title);
    }

    @Override
    public Description getFilm(String title) {
        return this.imdbDao.getFilms(title).get(0);
    }

    

}
