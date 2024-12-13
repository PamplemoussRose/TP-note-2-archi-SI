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

        /*TestBean bean1 = insertBeanInDB("aa", "a");
        testBusiness.addTest(bean1);

        TestBean bean2 = insertBeanInDB("bb", "b");
        testBusiness.addTest(bean2);

        TestBean bean3 = insertBeanInDB("cc", "c");
        testBusiness.addTest(bean3);

        TestBean bean4 = insertBeanInDB("dd", "d");
        testBusiness.addTest(bean4);

        TestBean bean5 = insertBeanInDB(, "e");
        testBusiness.addTest(bean5);

        TestBean bean6 = insertBeanInDB("ff", "f");
        testBusiness.addTest(bean6);*/ 
    }

    private TestBean insertBeanInDB(Integer nom, String prenom) {
        TestBean bean = new TestBean();

        bean.setNOTE(nom);
        bean.setTITLE(prenom);

        return bean;
    }
}
