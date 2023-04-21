package org.iti;

import org.iti.services.FilmActorServices;
import org.iti.services.FilmCategoryServices;

public class App {
    public static void main(String[] args) {
        FilmCategoryServices services = new FilmCategoryServices();
        System.out.println("services.getFilmActorById(1) = " + services.getFilmCategoryByCategory_Film(1,6).getCategory());
    }
}
