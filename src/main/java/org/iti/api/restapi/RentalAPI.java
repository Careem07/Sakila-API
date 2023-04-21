package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.RentalDto;
import org.iti.services.RentalServices;

import java.util.List;

@Path("rentals")
public class RentalAPI {

    RentalServices services = new RentalServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRental(@PathParam("id") int id){
        RentalDto RentalDto = services.getRentalById(id);
        if(RentalDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(RentalDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentals(){
        List<RentalDto> Rentals = services.getRentals();
        return Response.ok(Rentals).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRental(RentalDto RentalDto){
        RentalDto dto = services.createRental(RentalDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeRental(@PathParam("id") int id){
        boolean check = services.removeRental(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRental(@PathParam("id") int id, RentalDto RentalDto) {
        RentalDto dto = services.updateRental(id,RentalDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }


}
