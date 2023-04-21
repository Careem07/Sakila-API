package org.iti.services;


import org.iti.model.dto.AddressDto;
import org.iti.model.dto.StaffDto;
import org.iti.model.dto.StoreDto;
import org.iti.model.entities.Address;
import org.iti.model.entities.Staff;
import org.iti.model.entities.Store;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import java.time.Instant;
import java.util.List;

public class StoreServices {

    RepositoryImpl<Store> repository = new RepositoryImpl<>(Store.class);

    public StoreDto createStore(StoreDto storeDto){
        storeDto.setLastUpdate(Instant.now());
        Store store = new ModelMapper().map(storeDto,Store.class);
        repository.create(store);
        return storeDto;
    }
    public StoreDto getStoreById(int id){
        Store store = repository.findById(id);
//        new ModelMapper().typeMap(Store.class , StoreDto.class).addMapping(mapper ->{
//            mapper.map(src -> src.getBillingAddress().getStreet(),
//                    Destination::setBillingStreet);
//        });
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setDeepCopyEnabled(true);
        return mapper.map(store , StoreDto.class);
    }
    public List<StoreDto> getStores(){
        List<Store> stores = repository.findAll();
        return new ModelMapper().map(stores,new TypeToken<List<StoreDto>>(){}.getType());
    }

    public boolean removeStore(int id){
        Store store = repository.findById(id);
        return repository.remove(store);
    }

    public StoreDto updateStore(int id , StoreDto storeDto){
        Store store = repository.findById(id);
        AddressDto addressDto = new AddressDto(storeDto.getAddress().getAddress());
        StaffDto managerDto = new StaffDto(storeDto.getManagerStaff().getFirstName(),storeDto.getManagerStaff().getLastName());
        Address address = new ModelMapper().map(addressDto , Address.class);
        Staff staff = new ModelMapper().map(managerDto , Staff.class);
        store.setAddress(address);
        store.setManagerStaff(staff);
        Store newStore = repository.update(store);
        return new ModelMapper().map(newStore , StoreDto.class);
    }

}
