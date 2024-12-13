package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.model.TestBean;

public interface TestBusiness {

    public void addTest(TestBean bean);

    public List<TestBean> getTests(boolean desc, String note);

    public TestBean getTest(int id);

    public void updateTest(TestBean bean);

    public void deleteTest(int id);
}
