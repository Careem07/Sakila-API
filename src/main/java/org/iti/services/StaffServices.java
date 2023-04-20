package org.iti.services;

import org.iti.model.dto.StaffDto;
import org.iti.model.entities.Staff;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class StaffServices {
    RepositoryImpl<Staff> repository = new RepositoryImpl<>(Staff.class);

    public StaffDto createStaff(StaffDto staffDto){
        staffDto.setLastUpdate(Instant.now());
        Staff staff = new ModelMapper().map(staffDto,Staff.class);
        repository.create(staff);
        return staffDto;
    }
    public StaffDto getStaffById(int id){
        Staff staff = repository.findById(id);
        System.out.println("staff = " + staff.getEmail());
//        Map mapper = Mappers.getMapper(Map.class);
//        StaffDto staffDto = mapper.toDto(staff);
        return new ModelMapper().map(staff , StaffDto.class);
    }
    public List<StaffDto> getStaffs(){
        List<Staff> staffs = repository.findAll();
        return new ModelMapper().map(staffs,new TypeToken<List<StaffDto>>(){}.getType());
    }

    public boolean removeStaff(int id){
        Staff staff = repository.findById(id);
        return repository.remove(staff);
    }

    public StaffDto updateStaff(int id , StaffDto storeDto){
        Staff staff = repository.findById(id);
        Staff newStaff = repository.update(staff);
        return new ModelMapper().map(newStaff , StaffDto.class);
    }
}
