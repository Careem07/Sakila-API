package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.PaymentDto;
import org.iti.services.PaymentServices;

import java.util.List;

@WebService
public class PaymentWs {

    PaymentServices services = new PaymentServices();

    public List<PaymentDto> getPayments(){
        return services.getPayments();
    }


    public String createPayment(PaymentDto paymentDto){
        PaymentDto newPayment = services.createPayment(paymentDto);
        if (newPayment == null)   return "failed";
        return "success";
    }

    public PaymentDto getPayment(@WebParam(name = "id") int id){
        PaymentDto paymentDto = services.getPaymentById(id);
        return paymentDto;
    }

    public String updatePayment(@WebParam(name = "id") int id,PaymentDto paymentDto) {
        PaymentDto dto = services.updatePayment(id,paymentDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }





}
