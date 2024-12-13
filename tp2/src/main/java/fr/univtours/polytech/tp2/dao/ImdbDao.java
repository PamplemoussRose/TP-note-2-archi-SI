package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.film.Description;

public interface ImdbDao {

    public List<Description> getFilms(String search);
    
}
