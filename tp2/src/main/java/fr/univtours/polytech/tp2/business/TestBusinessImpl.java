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
    public List<TestBean> getTests(boolean desc) {
        if (desc) {
            return this.testDao.getTests(desc);
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

}
