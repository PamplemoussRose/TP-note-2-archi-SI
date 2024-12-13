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

        String title1 = "Le cinquieme element";
        TestBean bean1 = insertBeanInDB(title1, 3);
        testBusiness.addTest(bean1);

        String title2 = "Le parrain";
        TestBean bean2 = insertBeanInDB(title2, 2);
        testBusiness.addTest(bean2);

        String title3 = "Apocalypse Now";
        TestBean bean3 = insertBeanInDB(title3, 3);
        testBusiness.addTest(bean3);

        String title4 = "Le seigneur des anneaux";
        TestBean bean4 = insertBeanInDB(title4, 4);
        testBusiness.addTest(bean4);

        String title5 = "Star Wars";
        TestBean bean5 = insertBeanInDB(title5, 5);
        testBusiness.addTest(bean5);

        String title6 = "Cars";
        TestBean bean6 = insertBeanInDB(title6, 0);
        testBusiness.addTest(bean6);

    }

    private TestBean insertBeanInDB(String title, Integer note) {
        TestBean bean = new TestBean();

        bean.setNote(note);
        bean.setTitle(title);

        return bean;
    }
}
