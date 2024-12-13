package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.TestBean;

public interface TestDao {

    public void addTest(TestBean test);

    public List<TestBean> getTests();

    public List<TestBean> getTests(boolean desc);
    
    public List<TestBean> getTests(String note);
    
    public List<TestBean> getTests(boolean desc, String note);

    public TestBean getTestById(int id);

    public void updateTest(TestBean test);

    public void deleteTest(TestBean test);
}
