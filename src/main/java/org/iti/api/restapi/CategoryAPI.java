package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.CategoryDto;
import org.iti.services.CategoryServices;

import java.util.List;

@Path("categories")
public class CategoryAPI {
    CategoryServices services = new CategoryServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") int id){
        CategoryDto customerDto = services.getCategoryById(id);
        if(customerDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorys(){
        List<CategoryDto> customers = services.getCategories();
        return Response.ok(customers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryDto customerDto1){
        CategoryDto customerDto = services.createCategory(customerDto1);
        if(customerDto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customerDto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeCategory(@PathParam("id") int id){
        boolean check = services.removeCategory(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") int id, CategoryDto actorDto) {
        CategoryDto dto = services.updateCategory(id,actorDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }
}
