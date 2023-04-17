package org.iti;

import org.iti.services.FilmActorServices;

public class App {
    public static void main(String[] args) {
        FilmActorServices services = new FilmActorServices();
        System.out.println("services.getFilmActorById(1) = " + services.getFilmActorByActor_Film(1,1));
    }
}
