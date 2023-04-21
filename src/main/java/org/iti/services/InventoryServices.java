package org.iti.services;

import org.iti.model.dto.InventoryDto;
import org.iti.model.entities.Inventory;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class InventoryServices {

    RepositoryImpl<Inventory> repository = new RepositoryImpl<>(Inventory.class);

    public InventoryDto createInventory(InventoryDto inventoryDto){
        System.out.println("inventoryDto = " + inventoryDto);
        inventoryDto.setLastUpdate(Instant.now());
        Inventory inventory = new ModelMapper().map(inventoryDto,Inventory.class);
        if(repository.create(inventory) == null){
            return null;
        }
        return inventoryDto;
    }

    public InventoryDto getInventoryById(int id){
        Inventory inventory = repository.findById(id);
        if (inventory == null) return null;
        return new ModelMapper().map(inventory,InventoryDto.class);
    }

    public List<InventoryDto> getInventories(){
        List<Inventory> inventories = repository.findAll();
        return new ModelMapper().map(inventories,new TypeToken<List<InventoryDto>>(){}.getType());
    }

    public boolean removeInventory(int id){
        Inventory inventory = repository.findById(id);
        return repository.remove(inventory);
    }

    public InventoryDto updateInventory(int id , InventoryDto inventoryDto){
        Inventory Inventory = repository.findById(id);


        Inventory newInventory = repository.update(Inventory);
        return new ModelMapper().map(newInventory , InventoryDto.class);
    }
}
