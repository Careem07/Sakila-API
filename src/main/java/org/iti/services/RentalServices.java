package org.iti.services;

import org.iti.model.dto.RentalDto;
import org.iti.model.entities.Rental;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class RentalServices {

    RepositoryImpl<Rental> repository = new RepositoryImpl<>(Rental.class);

    public RentalDto createRental(RentalDto rentalDto){
        rentalDto.setLastUpdate(Instant.now());
        rentalDto.setRentalDate(Instant.now());
        Rental Rental = new ModelMapper().map(rentalDto,Rental.class);
        if(repository.create(Rental) == null){
            return null;
        }
        return rentalDto;
    }

    public RentalDto getRentalById(int id){
        Rental Rental = repository.findById(id);
        if (Rental == null) return null;
        RentalDto map = new ModelMapper().map(Rental, RentalDto.class);
        System.out.println("map = " + map);
        return map;
    }

    public List<RentalDto> getRentals(){
        List<Rental> Rentals = repository.findAll();
        return new ModelMapper().map(Rentals,new TypeToken<List<RentalDto>>(){}.getType());
    }

    public boolean removeRental(int id){
        Rental Rental = repository.findById(id);
        return repository.remove(Rental);
    }

    public RentalDto updateRental(int id , RentalDto RentalDto){
        Rental Rental = repository.findById(id);
        Rental.setRentalDate(RentalDto.getRentalDate());
        Rental newRental = repository.update(Rental);
        return new ModelMapper().map(newRental , RentalDto.class);
    }

}
