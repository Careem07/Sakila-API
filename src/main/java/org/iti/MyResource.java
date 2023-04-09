package org.iti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.iti.entities.Actor;
import org.iti.repositories.RepositoryImpl;

import java.time.Instant;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    RepositoryImpl<Actor> repo = new RepositoryImpl<>(Actor.class);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Actor getIt() {
//       return repo.create(new Actor("test" , "test" ,  Instant.parse("2021-07-07T02:09:47Z")));
        return repo.findById(4);

    }
}
