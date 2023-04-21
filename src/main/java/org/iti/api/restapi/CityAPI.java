package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.CityDto;
import org.iti.services.CityServices;

import java.util.List;

@Path("cities")
public class CityAPI {

    CityServices services = new CityServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCity(@PathParam("id") int id){
        CityDto cityDto = services.getCityById(id);
        if(cityDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(cityDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities(){
        List<CityDto> cities = services.getCities();
        return Response.ok(cities).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(CityDto cityDto){
        CityDto dto = services.createCity(cityDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeCity(@PathParam("id") int id){
        boolean check = services.removeCity(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(@PathParam("id") int id, CityDto cityDto) {
        CityDto dto = services.updateCity(id,cityDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }
}
