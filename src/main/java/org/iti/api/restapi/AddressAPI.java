package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.AddressDto;
import org.iti.services.AddressServices;

import java.util.List;

@Path("addresses")
public class AddressAPI {

    AddressServices services = new AddressServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@PathParam("id") int id){
        AddressDto addressDto = services.getAddressById(id);
        if(addressDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(addressDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddresses(){
        List<AddressDto> cities = services.getAddresses();
        return Response.ok(cities).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(AddressDto AddressDto){
        AddressDto dto = services.createAddress(AddressDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeAddress(@PathParam("id") int id){
        boolean check = services.removeAddress(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAddress(@PathParam("id") int id, AddressDto AddressDto) {
        AddressDto dto = services.updateAddress(id,AddressDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
