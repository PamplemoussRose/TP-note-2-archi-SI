package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;

public interface Filmusiness {

    public void addFilm(FilmBean bean);

    public List<FilmBean> getFilms(boolean desc, String note);

    public FilmBean getFilm(int id);

    public void updateFilm(FilmBean bean);

    public void deleteFilm(int id);

    public void updateNote(int id, boolean up);
}
