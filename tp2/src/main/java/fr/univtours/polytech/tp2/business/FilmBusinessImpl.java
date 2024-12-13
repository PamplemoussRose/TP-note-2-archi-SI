package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.dao.FilmDao;
import fr.univtours.polytech.tp2.model.FilmBean;
import fr.univtours.polytech.tp2.model.film.Description;
import jakarta.inject.Inject;

public class FilmBusinessImpl implements Filmusiness {

    @Inject
    private FilmDao testDao;

    @Inject
    private ImdbBusiness imdbBusiness;

    @Override
    public void addFilm(FilmBean bean) {
        this.testDao.addFilm(bean);
    }

    @Override
    public List<FilmBean> getFilms(boolean desc, String note) {
        List<FilmBean> list = null;

        if (desc && note != null) {
            list = this.testDao.getFilms(desc, note);
        } else if (desc) {
            list = this.testDao.getFilms(desc);
        } else if (note != null) {
            list = this.testDao.getFilms(note);
        } else {
            list = this.testDao.getFilms();
        }

        for (FilmBean bean : list) {
            Description info = this.imdbBusiness.getFilm(bean.getTitle());
            bean.setActeur(info.getActors());
            bean.setImage(info.getImgPoster());
            bean.setSortie(info.getYear());
        }

        return list;
    }

    @Override
    public FilmBean getFilm(int id) {
        FilmBean bean = this.testDao.getFilmById(id);
        bean.setActeur(this.imdbBusiness.getFilm(bean.getTitle()).getActors());
        bean.setImage(this.imdbBusiness.getFilm(bean.getTitle()).getImgPoster());
        bean.setSortie(this.imdbBusiness.getFilm(bean.getTitle()).getYear());
        return bean;
    }

    @Override
    public void updateFilm(FilmBean bean) {
        this.testDao.updateFilm(bean);
    }

    @Override
    public void deleteFilm(int id) {
        FilmBean bean = this.testDao.getFilmById(id);
        this.testDao.deleteFilm(bean);
    }

    @Override
    public void updateNote(int id, boolean up) {
        FilmBean bean = this.testDao.getFilmById(id);
        if (up) {
            if (bean.getNote() == 5) {
                return;
            } else if (bean.getNote() == 0) {
                bean.setNote(1);
            } else {
                bean.setNote(bean.getNote() + 1);
            }
        } else {
            if (bean.getNote() == 1) {
                return;
            } else if (bean.getNote() == 0) {
                bean.setNote(5);
            } else {
                bean.setNote(bean.getNote() - 1);
            }
        }
        this.testDao.updateFilm(bean);
    }

}
