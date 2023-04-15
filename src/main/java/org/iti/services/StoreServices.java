package org.iti.services;


import org.iti.model.dto.StoreDto;
import org.iti.model.entities.Store;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class StoreServices {

    RepositoryImpl<Store> repository = new RepositoryImpl<>(Store.class);

    public StoreDto createStore(StoreDto storeDto){
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
        return new ModelMapper().map(store , StoreDto.class);
    }
    public List<StoreDto> getStores(){
        List<Store> stores = repository.findAll();
        return new ModelMapper().map(stores,new TypeToken<List<StoreDto>>(){}.getType());
    }

    public boolean removeStore(int id){
        Store store = repository.findById(id);
        return repository.remove(store);
    }

}
