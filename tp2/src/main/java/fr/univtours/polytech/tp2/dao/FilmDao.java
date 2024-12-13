package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;

public interface FilmDao {

    public void addFilm(FilmBean test);

    public List<FilmBean> getFilms();

    public List<FilmBean> getFilms(boolean desc);
    
    public List<FilmBean> getFilms(String note);
    
    public List<FilmBean> getFilms(boolean desc, String note);

    public FilmBean getFilmById(int id);

    public void updateFilm(FilmBean test);

    public void deleteFilm(FilmBean test);
}
