package org.iti.services;

import jakarta.ws.rs.SeBootstrap;
import org.iti.model.dto.CustomerDto;
import org.iti.model.dto.StoreDto;
import org.iti.model.entities.Customer;
import org.iti.model.entities.Customer;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;

import java.time.Instant;
import java.util.List;

public class CustomerServices {

    RepositoryImpl<Customer> repository = new RepositoryImpl<>(Customer.class);
    public CustomerDto getCustomerById(int id){
        Customer customer = repository.findById(id);
        return new ModelMapper().map(customer , CustomerDto.class);
    }

    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = repository.findAll();
        return new ModelMapper().map(customers , new TypeToken<List<CustomerDto>>(){}.getType());
    }

    public CustomerDto createCustomer(CustomerDto customerDto){
        customerDto.setLastUpdate(Instant.now());
        Customer customer = new ModelMapper().map(customerDto , Customer.class);
        repository.create(customer);
        return customerDto;
    }
    public boolean removeCustomer(int id){
        Customer customer = repository.findById(id);
        return repository.remove(customer);
    }

    public CustomerDto updateCustomer(int id , CustomerDto customerDto){
        Customer customer = repository.findById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
//        customer.setEmail(customerDto.getEmail());
        Customer newCustomer = repository.update(customer);
        return new ModelMapper().map(newCustomer , CustomerDto.class);
    }

}
