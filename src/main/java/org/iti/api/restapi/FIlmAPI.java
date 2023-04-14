package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.iti.model.dto.FilmDto;
import org.iti.services.FIlmServices;

import java.util.List;

@Path("films")
public class FIlmAPI {

    FIlmServices services = new FIlmServices();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilm(@PathParam("id") int id){
        FilmDto filmDto = services.getFilmById(id);
        System.out.println("filmDto.getDescription() = " + filmDto.getDescription());
        if(filmDto == null)  return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(filmDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilms(){
        List<FilmDto> films = services.getFilms();
        return Response.ok(films).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm(FilmDto filmDto){
        FilmDto filmDto1 = services.createFilm(filmDto);
        if(filmDto1 == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(filmDto1).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeFilm(@PathParam("id") int id){
        boolean check = services.removeFilm(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }
}
