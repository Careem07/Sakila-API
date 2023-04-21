package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.InventoryDto;
import org.iti.services.InventoryServices;

import java.util.List;

@Path("inventories")
public class InventoryAPI {

    InventoryServices services = new InventoryServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventory(@PathParam("id") int id){
        InventoryDto InventoryDto = services.getInventoryById(id);
        if(InventoryDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(InventoryDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventories(){
        List<InventoryDto> cities = services.getInventories();
        return Response.ok(cities).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addInventory(InventoryDto InventoryDto){
        InventoryDto dto = services.createInventory(InventoryDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeInventory(@PathParam("id") int id){
        boolean check = services.removeInventory(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateInventory(@PathParam("id") int id, InventoryDto InventoryDto) {
        InventoryDto dto = services.updateInventory(id,InventoryDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
