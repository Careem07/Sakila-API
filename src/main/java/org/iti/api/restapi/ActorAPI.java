package org.iti.api.restapi;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.ActorDto;
import org.iti.services.ActorServices;


import java.util.List;

@Path("actors")
public class ActorAPI  {

    ActorServices services = new ActorServices();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorDto> getActors(){
        return services.getActors();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createActor(ActorDto actorDto){
        ActorDto newActor = services.addActor(actorDto);

        if (newActor == null)   return Response.status(Response.Status.FORBIDDEN).build();

        return Response.status(Response.Status.CREATED).entity(newActor).build();

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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(@PathParam("id") int id,ActorDto actorDto) {
        ActorDto dto = services.updateActor(id,actorDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
