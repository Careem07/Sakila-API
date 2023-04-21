package org.iti.services;

import org.iti.model.dto.AddressDto;
import org.iti.model.entities.Address;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class AddressServices {
    RepositoryImpl<Address> repository = new RepositoryImpl<>(Address.class);

    public AddressDto getAddressById(int id){
        Address address = repository.findById(id);
        ModelMapper model = new ModelMapper();
       AddressDto addressDto = model.map(address,AddressDto.class);
        return addressDto;
    }

    public AddressDto createAddress(AddressDto addressDto){
        addressDto.setLastUpdate(Instant.now());
        Address Address = new ModelMapper().map(addressDto,Address.class);
        if(repository.create(Address) == null){
            return null;
        }
        return addressDto;
    }

    public List<AddressDto> getAddresses(){
        List<Address> Address = repository.findAll();
        return new ModelMapper().map(Address,new TypeToken<List<AddressDto>>(){}.getType());
    }

    public boolean removeAddress(int id){
        Address Address = repository.findById(id);
        return repository.remove(Address);
    }

    public AddressDto updateAddress(int id , AddressDto addressDto){
        Address address = repository.findById(id);
        address.setDistrict(addressDto.getDistrict());
        Address newAddress = repository.update(address);
        return new ModelMapper().map(newAddress , AddressDto.class);
    }


}
