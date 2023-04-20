package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.RentalDto;
import org.iti.services.RentalServices;

import java.util.List;

@WebService
public class RentalWs {

    RentalServices services = new RentalServices();

    public List<RentalDto> getRentals(){
        return services.getRentals();
    }


    public String createRental(RentalDto rentalDto){
        RentalDto newRental = services.createRental(rentalDto);
        if (newRental == null)   return "failed";
        return "success";
    }

    public RentalDto getRental(@WebParam(name = "id") int id){
        return services.getRentalById(id);
    }

    public String updateRental(@WebParam(name = "id") int id,RentalDto rentalDto) {
        RentalDto dto = services.updateRental(id,rentalDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }





}
