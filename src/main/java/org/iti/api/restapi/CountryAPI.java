package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.CountryDto;
import org.iti.services.CountryServices;

import java.util.List;

@Path("countries")
public class CountryAPI {
    CountryServices services = new CountryServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry(@PathParam("id") int id){
        CountryDto customerDto = services.getCountryById(id);
        if(customerDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountries(){
        List<CountryDto> customers = services.getCountries();
        return Response.ok(customers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(CountryDto customerDto1){
        CountryDto customerDto = services.createCountry(customerDto1);
        if(customerDto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeCountry(@PathParam("id") int id){
        boolean check = services.removeCountry(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCountry(@PathParam("id") int id, CountryDto cityDto) {
        CountryDto dto = services.updateCountry(id,cityDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }
}
