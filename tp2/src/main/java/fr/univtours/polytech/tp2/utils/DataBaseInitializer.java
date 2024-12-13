package fr.univtours.polytech.tp2.utils;

import fr.univtours.polytech.tp2.business.TestBusiness;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DataBaseInitializer {

    @Inject
    private TestBusiness testBusiness;

    @PostConstruct
    public void init() {

        TestBean bean1 = insertBeanInDB(1, "a");
        testBusiness.addTest(bean1);

    }

    private TestBean insertBeanInDB(Integer note, String title) {
        TestBean bean = new TestBean();

        bean.setNOTE(note);
        bean.setTITLE(title);

        return bean;
    }
}
