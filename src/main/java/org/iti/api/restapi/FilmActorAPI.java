package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.FilmActorDto;
import org.iti.services.FilmActorServices;

import java.util.List;

@Path("filmactors")
public class FilmActorAPI {

    FilmActorServices services = new FilmActorServices();
    @GET
    @Path("{id1}/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmActorByActor_Film(@PathParam("id1") int id1 , @PathParam("id2") int id2){
        FilmActorDto FilmActorDto = services.getFilmActorByActor_Film(id1,id2);
        if(FilmActorDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(FilmActorDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmActors(){
        List<FilmActorDto> cities = services.getFilmActors();
        return Response.ok(cities).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilmActor(FilmActorDto filmActorDto){
        FilmActorDto dto = services.createFilmActor(filmActorDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeFilmActor(@PathParam("id") int id){
        boolean check = services.removeFilmActor(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFilmActor(@PathParam("id") int id, FilmActorDto filmActorDto) {
        FilmActorDto dto = services.updateFilmActor(id,filmActorDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
