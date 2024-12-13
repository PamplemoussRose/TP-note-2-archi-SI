package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TestDaoImpl implements TestDao {

    @PersistenceContext(unitName = "tp2")
    private EntityManager em;

    @Override
    public void addTest(TestBean test) {
        em.persist(test);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TestBean> getTests() {
        Query request = em.createQuery("select l from TestBean l");
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TestBean> getTests(boolean desc) {
        Query request = em.createQuery("select l from TestBean l order by id desc");
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TestBean> getTests(String note) {
        Query request = em.createQuery("select l from TestBean l where l.note = "+note);
        return request.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TestBean> getTests(boolean desc, String note) {
        Query request = em.createQuery("select l from TestBean l where l.note = "+note+" order by id desc");
        return request.getResultList();
    }

    @Override
    public TestBean getTestById(int id) {
        return em.find(TestBean.class, id);
    }

    @Override
    public void updateTest(TestBean test) {
        em.merge(test);
    }

    @Override
    public void deleteTest(TestBean test) {
        TestBean attachedTest = em.merge(test);
        em.remove(attachedTest);
    }

}
