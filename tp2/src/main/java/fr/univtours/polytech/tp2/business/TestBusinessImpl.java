package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.dao.TestDao;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.inject.Inject;

public class TestBusinessImpl implements TestBusiness {

    @Inject
    private TestDao testDao;

    @Override
    public void addTest(TestBean bean) {
        this.testDao.addTest(bean);
    }

    @Override
    public List<TestBean> getTests(boolean desc, String note) {
        if (desc && note != null) {
            return this.testDao.getTests(desc, note);
        } else if (desc) {
            return this.testDao.getTests(desc);
        } else if (note != null) {
            return this.testDao.getTests(note);
        } else {
            return this.testDao.getTests();
        }
    }

    @Override
    public TestBean getTest(int id) {
        return this.testDao.getTestById(id);
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
