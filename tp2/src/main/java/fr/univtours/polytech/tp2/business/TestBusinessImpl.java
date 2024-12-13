package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.dao.TestDao;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.inject.Inject;

public class TestBusinessImpl implements TestBusiness {

    @Inject
    private TestDao testDao;

    @Inject
    private ImdbBusiness imdbBusiness;

    @Override
    public void addTest(TestBean bean) {
        this.testDao.addTest(bean);
    }

    @Override
    public List<TestBean> getTests(boolean desc, String note) {
        List<TestBean> list = null;

        if (desc && note != null) {
            list = this.testDao.getTests(desc, note);
        } else if (desc) {
            list = this.testDao.getTests(desc);
        } else if (note != null) {
            list = this.testDao.getTests(note);
        } else {
            list = this.testDao.getTests();
        }

        for (TestBean bean : list) {
            bean.setActeur(this.imdbBusiness.getFilm(bean.getTitle()).getActors());
            bean.setImage(this.imdbBusiness.getFilm(bean.getTitle()).getImgPoster());
            bean.setSortie(this.imdbBusiness.getFilm(bean.getTitle()).getYear());
        }

        return list;
    }

    @Override
    public TestBean getTest(int id) {
        TestBean bean = this.testDao.getTestById(id);
        bean.setActeur(this.imdbBusiness.getFilm(bean.getTitle()).getActors());
        bean.setImage(this.imdbBusiness.getFilm(bean.getTitle()).getImgPoster());
        bean.setSortie(this.imdbBusiness.getFilm(bean.getTitle()).getYear());
        return bean;
    }

    @Override
    public void updateTest(TestBean bean) {
        this.testDao.updateTest(bean);
    }

    @Override
    public void deleteTest(int id) {
        TestBean bean = this.testDao.getTestById(id);
        this.testDao.deleteTest(bean);
    }

    @Override
    public void updateNote(int id, boolean up) {
        TestBean bean = this.testDao.getTestById(id);
        if (up) {
            if (bean.getNote() == 5) {
                return;
            }
            bean.setNote(bean.getNote() + 1);
        } else {
            if (bean.getNote() == 1) {
                return;
            }
            bean.setNote(bean.getNote() - 1);
        }
        this.testDao.updateTest(bean);
    }

}
