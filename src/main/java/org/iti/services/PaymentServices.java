package org.iti.services;

import org.iti.model.dto.PaymentDto;
import org.iti.model.entities.Payment;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class PaymentServices {
    RepositoryImpl<Payment> repository = new RepositoryImpl<>(Payment.class);

    public PaymentDto createPayment(PaymentDto paymentDto){
        paymentDto.setPaymentDate(Instant.now());
        Payment payment = new ModelMapper().map(paymentDto,Payment.class);
        if(repository.create(payment) == null){
            return null;
        }
        return paymentDto;
    }

    public PaymentDto getPaymentById(int id){
        Payment payment = repository.findById(id);
        if (payment == null) return null;
        return new ModelMapper().map(payment,PaymentDto.class);
    }

    public List<PaymentDto> getPayments(){
        List<Payment> payments = repository.findAll();
        return new ModelMapper().map(payments,new TypeToken<List<PaymentDto>>(){}.getType());
    }

    public boolean removePayment(int id){
        Payment payment = repository.findById(id);
        return repository.remove(payment);
    }

    public PaymentDto updatePayment(int id , PaymentDto paymentDto){
        Payment payment = repository.findById(id);
        payment.setPaymentDate(Instant.now());
        payment.setAmount(paymentDto.getAmount());
        Payment newPayment = repository.update(payment);
        return new ModelMapper().map(newPayment , PaymentDto.class);
    }

}
