package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.CustomerDto;
import org.iti.model.dto.StoreDto;
import org.iti.model.dto.StoreDto;
import org.iti.services.StoreServices;

import java.util.List;

@Path("stores")
public class StoreAPI {

    StoreServices services = new StoreServices();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStore(StoreDto storeDto){
        StoreDto dto = services.createStore(storeDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreDto> getStores(){
        return services.getStores();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStore(@PathParam("id") int id){
        StoreDto storeDto = services.getStoreById(id);
        if(storeDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(storeDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeStore(@PathParam("id") int id){
        boolean check = services.removeStore(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    public Response updateStore(@PathParam("id") int id , StoreDto storeDto){
        StoreDto dto = services.updateStore(id,storeDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }



}
