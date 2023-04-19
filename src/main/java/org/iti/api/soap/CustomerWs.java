package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.CustomerDto;
import org.iti.services.CustomerServices;

import java.util.List;

@WebService
public class CustomerWs {

    CustomerServices services = new CustomerServices();

    public List<CustomerDto> getCustomers(){
        return services.getAllCustomers();
    }


    public String createCustomer(CustomerDto countryDto){
        CustomerDto newCustomer = services.createCustomer(countryDto);
        if (newCustomer == null)   return "failed";
        return "success";
    }

    public CustomerDto getCustomer(@WebParam(name = "id") int id){
        CustomerDto countryById = services.getCustomerById(id);
        return countryById;
    }

    public String updateCustomer(@WebParam(name = "id") int id,CustomerDto countryDto) {
        CustomerDto dto = services.updateCustomer(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
