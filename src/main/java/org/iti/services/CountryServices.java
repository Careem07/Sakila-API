package org.iti.services;

import org.iti.model.dto.CountryDto;
import org.iti.model.entities.Country;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class CountryServices {
    RepositoryImpl<Country> repository = new RepositoryImpl<>(Country.class);

    public CountryDto createCountry(CountryDto countryDto){
        countryDto.setLastUpdate(Instant.now());
        Country country = new ModelMapper().map(countryDto,Country.class);
        if(repository.create(country) == null){
            return null;
        }
        return countryDto;
    }

    public CountryDto getCountryById(int id){
        Country country = repository.findById(id);
        if (country == null) return null;
        return new ModelMapper().map(country,CountryDto.class);
    }

    public List<CountryDto> getCountries(){
        List<Country> countries = repository.findAll();
        return new ModelMapper().map(countries,new TypeToken<List<CountryDto>>(){}.getType());
    }

    public boolean removeCountry(int id){
        Country country = repository.findById(id);
        return repository.remove(country);
    }

    public CountryDto updateCountry(int id , CountryDto countryDto){
        Country country1 = repository.findById(id);
        country1.setCountry(country1.getCountry());
        country1.setLastUpdate(countryDto.getLastUpdate());
        Country newCountry = repository.update(country1);
        return new ModelMapper().map(newCountry , CountryDto.class);
    }
}
