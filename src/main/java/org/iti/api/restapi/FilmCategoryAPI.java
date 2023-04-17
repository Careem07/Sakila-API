package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.FilmCategoryDto;
import org.iti.model.dto.FilmCategoryDto;
import org.iti.services.FilmCategoryServices;

import java.util.List;

@Path("filmcategories")
public class FilmCategoryAPI {
    FilmCategoryServices services = new FilmCategoryServices();

    @GET
    @Path("{id1}/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmCategoryByCategory_Film(@PathParam("id1") int id1 , @PathParam("id2") int id2){
        FilmCategoryDto filmCategoryDto = services.getFilmCategoryByCategory_Film(id1,id2);
        if(filmCategoryDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(filmCategoryDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmCategories(){
        List<FilmCategoryDto> filmCategories = services.getFilmCategories();
        return Response.ok(filmCategories).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilmCategory(FilmCategoryDto filmCategoryDto){
        FilmCategoryDto dto = services.createFilmCategory(filmCategoryDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
}
