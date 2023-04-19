package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.CountryDto;
import org.iti.services.CountryServices;

import java.util.List;

@WebService
public class CountryWs {

    CountryServices services = new CountryServices();

    public List<CountryDto> getCountries(){
        return services.getCountries();
    }


    public String createCountry(CountryDto countryDto){
        CountryDto newCountry = services.createCountry(countryDto);
        if (newCountry == null)   return "failed";
        return "success";
    }

    public CountryDto getCountry(@WebParam(name = "id") int id){
        CountryDto countryById = services.getCountryById(id);
        return countryById;
    }

    public String updateCountry(@WebParam(name = "id") int id,CountryDto countryDto) {
        CountryDto dto = services.updateCountry(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
