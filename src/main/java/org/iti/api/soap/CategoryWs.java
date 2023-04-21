package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.CategoryDto;
import org.iti.services.CategoryServices;

import java.util.List;

@WebService
public class CategoryWs {

    CategoryServices services = new CategoryServices();

    public List<CategoryDto> getCategoryes(){
        return services.getCategories();
    }


    public String createCategory(CategoryDto categoryDto){
        CategoryDto newCategory = services.createCategory(categoryDto);
        if (newCategory == null)   return "failed";
        return "success";
    }

    public CategoryDto getCategory(@WebParam(name = "id") int id){
        CategoryDto CategoryDto = services.getCategoryById(id);
        return CategoryDto;
    }

    public String updateCategory(@WebParam(name = "id") int id,CategoryDto categoryDto) {
        CategoryDto dto = services.updateCategory(id,categoryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }


}
