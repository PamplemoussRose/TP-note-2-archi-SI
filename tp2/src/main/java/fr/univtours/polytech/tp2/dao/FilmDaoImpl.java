package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FilmDaoImpl implements FilmDao {

    @PersistenceContext(unitName = "tp2")
    private EntityManager em;

    @Override
    public void addFilm(FilmBean test) {
        em.persist(test);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmBean> getFilms() {
        Query request = em.createQuery("select l from FilmBean l");
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmBean> getFilms(boolean desc) {
        Query request = em.createQuery("select l from FilmBean l order by id desc");
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmBean> getFilms(String note) {
        Query request = em.createQuery("select l from FilmBean l where l.note = "+note);
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmBean> getFilms(boolean desc, String note) {
        Query request = em.createQuery("select l from FilmBean l where l.note = "+note+" order by id desc");
        return request.getResultList();
    }

    @Override
    public FilmBean getFilmById(int id) {
        return em.find(FilmBean.class, id);
    }

    @Override
    public void updateFilm(FilmBean test) {
        em.merge(test);
    }

    @Override
    public void deleteFilm(FilmBean test) {
        FilmBean attachedTest = em.merge(test);
        em.remove(attachedTest);
    }

}
