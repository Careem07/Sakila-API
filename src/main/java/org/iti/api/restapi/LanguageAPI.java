package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.LanguageDto;
import org.iti.services.LanguageServices;

import java.util.List;

@Path("languages")
public class LanguageAPI {
    LanguageServices services = new LanguageServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguage(@PathParam("id") int id){
        LanguageDto languageDto = services.getLanguageById(id);
        if(languageDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(languageDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguages(){
        List<LanguageDto> languages = services.getLanguages();
        return Response.ok(languages).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLanguage(LanguageDto languageDto){
        LanguageDto dto = services.createLanguage(languageDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeLanguage(@PathParam("id") int id){
        boolean check = services.removeLanguage(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLanguage(@PathParam("id") int id, LanguageDto languageDto) {
        LanguageDto dto = services.updateLanguage(id,languageDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
