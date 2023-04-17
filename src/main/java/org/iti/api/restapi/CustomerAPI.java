package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.CustomerDto;
import org.iti.services.CustomerServices;


import java.util.List;

@Path("customers")
public class CustomerAPI {

    CustomerServices services = new CustomerServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") int id){
        CustomerDto customerDto = services.getCustomerById(id);
        if(customerDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers(){
        List<CustomerDto> customers = services.getAllCustomers();
        return Response.ok(customers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDto customerDto1){
        CustomerDto customerDto = services.createCustomer(customerDto1);
        if(customerDto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeCustomer(@PathParam("id") int id){
        boolean check = services.removeCustomer(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, CustomerDto actorDto) {
        CustomerDto dto = services.updateCustomer(id,actorDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }
}
