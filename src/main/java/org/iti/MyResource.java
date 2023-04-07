package org.iti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.iti.entities.Actor;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

   EntityManagerFactory factory = Persistence.createEntityManagerFactory("sakila");
   EntityManager em = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Actor getIt() {
        Actor actor = em.find(Actor.class,4);
        System.out.println(actor.getFirstName());
        return actor;
    }
}
