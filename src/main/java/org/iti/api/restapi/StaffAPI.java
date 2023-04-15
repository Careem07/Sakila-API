package org.iti.api.restapi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.StaffDto;
import org.iti.services.StaffServices;


import java.util.List;

@Path("staffs")
public class StaffAPI {

    StaffServices services = new StaffServices();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getStaffs(){
        return services.getStaffs();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaff(@PathParam("id") int id){
        StaffDto storeDto = services.getStaffById(id);
        System.out.println("storeDto.getEmail() = " + storeDto.getEmail());
        if(storeDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(storeDto).build();
    }
}
