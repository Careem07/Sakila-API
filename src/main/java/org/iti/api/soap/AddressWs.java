package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.AddressDto;
import org.iti.services.AddressServices;

import java.util.List;

@WebService
public class AddressWs {

    AddressServices services = new AddressServices();

    public List<AddressDto> getAddresses(){
        return services.getAddresses();
    }


    public String createAddress(AddressDto addressDto){
        AddressDto newAddress = services.createAddress(addressDto);
        if (newAddress == null)   return "failed";
        return "success";
    }

    public AddressDto getAddress(@WebParam(name = "id") int id){
        AddressDto addressDto = services.getAddressById(id);
        return addressDto;
    }

    public String updateAddress(@WebParam(name = "id") int id,AddressDto addressDto) {
        AddressDto dto = services.updateAddress(id,addressDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
