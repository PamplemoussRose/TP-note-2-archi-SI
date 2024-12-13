package fr.univtours.polytech.tp2.utils;

import fr.univtours.polytech.tp2.business.Filmusiness;
import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DataBaseInitializer {

    @Inject
    private Filmusiness testBusiness;

    @PostConstruct
    public void init() {

        String title1 = "Le cinquieme element";
        FilmBean bean1 = insertBeanInDB(title1, 3);
        testBusiness.addFilm(bean1);

        String title2 = "Le parrain";
        FilmBean bean2 = insertBeanInDB(title2, 2);
        testBusiness.addFilm(bean2);

        String title3 = "Apocalypse Now";
        FilmBean bean3 = insertBeanInDB(title3, 3);
        testBusiness.addFilm(bean3);

        String title4 = "Le seigneur des anneaux";
        FilmBean bean4 = insertBeanInDB(title4, 4);
        testBusiness.addFilm(bean4);

        String title5 = "Star Wars";
        FilmBean bean5 = insertBeanInDB(title5, 5);
        testBusiness.addFilm(bean5);

        String title6 = "Cars";
        FilmBean bean6 = insertBeanInDB(title6, 0);
        testBusiness.addFilm(bean6);

    }

    private FilmBean insertBeanInDB(String title, Integer note) {
        FilmBean bean = new FilmBean();

        bean.setNote(note);
        bean.setTitle(title);

        return bean;
    }
}
