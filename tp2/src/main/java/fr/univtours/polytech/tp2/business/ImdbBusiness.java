package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.model.film.Description;

public interface ImdbBusiness {

    public List<Description> getFilms(String title);

    public Description getFilm(String title);
}
