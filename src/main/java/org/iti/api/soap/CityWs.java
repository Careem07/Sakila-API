package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.CityDto;
import org.iti.services.CityServices;

import java.util.List;

@WebService
public class CityWs {

    CityServices services = new CityServices();

    public List<CityDto> getCities(){
        return services.getCities();
    }


    public String createCity(CityDto cityDto){
        CityDto newCity = services.createCity(cityDto);
        if (newCity == null)   return "failed";
        return "success";
    }

    public CityDto getCity(@WebParam(name = "id") int id){
        CityDto CityDto = services.getCityById(id);
        return CityDto;
    }

    public String updateCity(@WebParam(name = "id") int id,CityDto cityDto) {
        CityDto dto = services.updateCity(id,cityDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }


}
