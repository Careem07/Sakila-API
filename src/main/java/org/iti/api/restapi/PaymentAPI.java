package org.iti.api.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.PaymentDto;
import org.iti.services.PaymentServices;

import java.util.List;

@Path("payments")
public class PaymentAPI {
    PaymentServices services = new PaymentServices();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayment(@PathParam("id") int id){
        PaymentDto paymentDto = services.getPaymentById(id);
        if(paymentDto == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(paymentDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayments(){
        List<PaymentDto> payments = services.getPayments();
        return Response.ok(payments).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPayment(PaymentDto paymentDto){
        PaymentDto dto = services.createPayment(paymentDto);
        if(dto == null )   return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dto).build();
    }
    @DELETE
    @Path("{id}")
    public Response removePayment(@PathParam("id") int id){
        boolean check = services.removePayment(id);
        if(check)
            return Response.status(Response.Status.ACCEPTED).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePayment(@PathParam("id") int id, PaymentDto paymentDto) {
        PaymentDto dto = services.updatePayment(id,paymentDto);
        if(dto == null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(dto).build();
    }

}
