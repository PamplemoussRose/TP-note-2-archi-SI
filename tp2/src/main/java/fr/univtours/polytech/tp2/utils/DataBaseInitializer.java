package fr.univtours.polytech.tp2.utils;

import fr.univtours.polytech.tp2.business.ImdbBusiness;
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

    @Inject
    private ImdbBusiness imdbBusiness;

    @PostConstruct
    public void init() {

        String title1 = "Le cinquieme element";
        TestBean bean1 = insertBeanInDB(title1, 3, imdbBusiness.getFilm(title1).getActors(), imdbBusiness.getFilm(title1).getYear(), imdbBusiness.getFilm(title1).getImgPoster());
        testBusiness.addTest(bean1);

        String title2 = "Le parrain";
        TestBean bean2 = insertBeanInDB(title2, 2, imdbBusiness.getFilm(title2).getActors(), imdbBusiness.getFilm(title2).getYear(), imdbBusiness.getFilm(title2).getImgPoster());
        testBusiness.addTest(bean2);

        String title3 = "Apocalypse Now";
        TestBean bean3 = insertBeanInDB(title3, 3, imdbBusiness.getFilm(title3).getActors(), imdbBusiness.getFilm(title3).getYear(), imdbBusiness.getFilm(title3).getImgPoster());
        testBusiness.addTest(bean3);

        String title4 = "Le seigneur des anneaux";
        TestBean bean4 = insertBeanInDB(title4, 4, imdbBusiness.getFilm(title4).getActors(), imdbBusiness.getFilm(title4).getYear(), imdbBusiness.getFilm(title4).getImgPoster());
        testBusiness.addTest(bean4);

        String title5 = "Star Wars";
        TestBean bean5 = insertBeanInDB(title5, 5, imdbBusiness.getFilm(title5).getActors(), imdbBusiness.getFilm(title5).getYear(), imdbBusiness.getFilm(title5).getImgPoster());
        testBusiness.addTest(bean5);

    }

    private TestBean insertBeanInDB(String title, Integer note, String acteur, Integer sortie, String image) {
        TestBean bean = new TestBean();

        bean.setNote(note);
        bean.setTitle(title);
        bean.setActeur(acteur);
        bean.setSortie(sortie);
        bean.setImage(image);

        return bean;
    }
}
