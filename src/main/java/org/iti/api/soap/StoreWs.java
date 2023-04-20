package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.StoreDto;
import org.iti.services.StoreServices;

import java.util.List;

@WebService
public class StoreWs {

    StoreServices services = new StoreServices();

    public List<StoreDto> getStores(){
        return services.getStores();
    }


    public String createStore(StoreDto storeDto){
        StoreDto newStore = services.createStore(storeDto);
        if (newStore == null)   return "failed";
        return "success";
    }

    public StoreDto getStore(@WebParam(name = "id") int id){
        StoreDto storeById = services.getStoreById(id);
        return storeById;
    }

    public String updateStore(@WebParam(name = "id") int id,StoreDto storeDto) {
        StoreDto dto = services.updateStore(id,storeDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
