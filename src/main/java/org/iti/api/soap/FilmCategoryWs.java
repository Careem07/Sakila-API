package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.FilmCategoryDto;
import org.iti.services.FilmCategoryServices;

import java.util.List;

@WebService
public class FilmCategoryWs {

    FilmCategoryServices services = new FilmCategoryServices();

    public List<FilmCategoryDto> getFilmCategorys(){
        return services.getFilmCategories();
    }


    public String createFilmCategory(FilmCategoryDto filmCategoryDto){
        FilmCategoryDto newFilmCategory = services.createFilmCategory(filmCategoryDto);
        if (newFilmCategory == null)   return "failed";
        return "success";
    }

    public FilmCategoryDto getFilmCategory(@WebParam(name = "id") int id1 , @WebParam(name = "id2") int id2){
        FilmCategoryDto countryById = services.getFilmCategoryByCategory_Film(id1 , id2);
        return countryById;
    }

    public String updateFilmCategory(@WebParam(name = "id") int id,FilmCategoryDto countryDto) {
        FilmCategoryDto dto = services.updateFilmCategory(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
