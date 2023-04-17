package org.iti.services;

import org.iti.model.dto.AddressDto;
import org.iti.model.entities.Address;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;

public class AddressServices {
    RepositoryImpl<Address> repository = new RepositoryImpl<>(Address.class);

    public void getAddressById(int id){
        Address address = repository.findById(id);
        ModelMapper model = new ModelMapper();
       AddressDto addressDto = model.map(address,AddressDto.class);
        System.out.println("addressDto = " + addressDto);
    }


}
