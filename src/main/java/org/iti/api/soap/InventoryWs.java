package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.InventoryDto;
import org.iti.services.InventoryServices;

import java.util.List;

@WebService
public class InventoryWs {

    InventoryServices services = new InventoryServices();

    public List<InventoryDto> getInventories(){
        return services.getInventories();
    }


    public String createInventory(InventoryDto filmDto){
        InventoryDto newInventory = services.createInventory(filmDto);
        if (newInventory == null)   return "failed";
        return "success";
    }

    public InventoryDto getInventory(@WebParam(name = "id") int id){
        InventoryDto inventoryById = services.getInventoryById(id);
        return inventoryById;
    }

    public String updateInventory(@WebParam(name = "id") int id,InventoryDto inventoryDto) {
        InventoryDto dto = services.updateInventory(id,inventoryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }



}
