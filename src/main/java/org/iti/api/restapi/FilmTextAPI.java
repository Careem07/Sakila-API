package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.FilmTextDto;
import org.iti.services.FilmTextServices;

import java.util.List;

public class FilmTextAPI {

    FilmTextServices services = new FilmTextServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmText(@PathParam("id") int id){
        FilmTextDto FilmTextDto = services.getFilmTextById(id);
        if(FilmTextDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(FilmTextDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmTexts(){
        List<FilmTextDto> FilmTexts = services.getFilmTexts();
        return Response.ok(FilmTexts).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilmText(FilmTextDto FilmTextDto){
        FilmTextDto dto = services.createFilmText(FilmTextDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeFilmText(@PathParam("id") int id){
        boolean check = services.removeFilmText(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFilmText(@PathParam("id") int id, FilmTextDto FilmTextDto) {
        FilmTextDto dto = services.updateFilmText(id,FilmTextDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
