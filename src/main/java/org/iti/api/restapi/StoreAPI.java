package org.iti.api.restapi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.StoreDto;
import org.iti.services.StoreServices;

import java.util.List;

@Path("stores")
public class StoreAPI {

    StoreServices services = new StoreServices();
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

}
