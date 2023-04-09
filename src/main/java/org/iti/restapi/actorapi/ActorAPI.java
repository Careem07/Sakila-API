package org.iti.restapi.actorapi;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.iti.dto.ActorDto;
import org.iti.dto.FilmActorDto;
import org.iti.entities.Actor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Path("actors")
public class ActorAPI {

    ActorServices services = new ActorServices();


    @GET
    public List<ActorDto> getActors(){
        return services.getActors();
    }

    @GET
    @Path("{id}")
    public Response getActor(@PathParam("id") int id){
        ActorDto actorDto = services.getActorById(id);
        if(actorDto == null)  return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(actorDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeActor(@PathParam("id") int id){
        boolean check = services.removeActor(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @PUT
    @Path("{id}")
    public Response updateActor(@PathParam("id") int id ,
                                @QueryParam("fname") String fName,
                                @QueryParam("lname") String lName) {
        ActorDto actorDto = services.getActorById(id);

        if(actorDto == null)  return Response.status(Response.Status.NOT_FOUND).build();

        actorDto.setFirstName(fName);
        actorDto.setLastName(lName);

        if(services.updateActor(actorDto) == null){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(actorDto).build();
    }


}
