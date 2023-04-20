package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.StaffDto;
import org.iti.services.StaffServices;

import java.util.List;

@WebService
public class StaffWs {

    StaffServices services = new StaffServices();

    public List<StaffDto> getStaffs(){
        return services.getStaffs();
    }


    public String createStaff(StaffDto staffDto){
        StaffDto newStaff = services.createStaff(staffDto);
        if (newStaff == null)   return "failed";
        return "success";
    }

    public StaffDto getStaff(@WebParam(name = "id") int id){
        StaffDto staffById = services.getStaffById(id);
        return staffById;
    }

    public String updateStaff(@WebParam(name = "id") int id,StaffDto languageDto) {
        StaffDto dto = services.updateStaff(id,languageDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }





}
