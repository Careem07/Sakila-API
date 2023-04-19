package org.iti.services;

import org.iti.model.dto.CityDto;
import org.iti.model.entities.City;
import org.iti.model.entities.Country;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class CityServices {

    RepositoryImpl<City> repository = new RepositoryImpl<>(City.class);

    public CityDto createCity(CityDto cityDto){
        cityDto.setLastUpdate(Instant.now());
        City city = new ModelMapper().map(cityDto,City.class);
        if(repository.create(city) == null){
            return null;
        }
        return cityDto;
    }

    public CityDto getCityById(int id){
        City city = repository.findById(id);
        if (city == null) return null;
        return new ModelMapper().map(city,CityDto.class);
    }

    public List<CityDto> getCities(){
        List<City> city = repository.findAll();
        return new ModelMapper().map(city,new TypeToken<List<CityDto>>(){}.getType());
    }

    public boolean removeCity(int id){
        City city = repository.findById(id);
        return repository.remove(city);
    }

    public CityDto updateCity(int id , CityDto cityDto){
        City city = repository.findById(id);
        city.setCity(cityDto.getCity());
//        Country country = new ModelMapper().map(cityDto.getCountry() , Country.class);
//        city.setCountry(country);
        City newCity = repository.update(city);
        return new ModelMapper().map(newCity , CityDto.class);
    }
}
