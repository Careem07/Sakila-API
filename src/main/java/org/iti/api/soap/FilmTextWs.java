package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.FilmTextDto;
import org.iti.services.FilmTextServices;

import java.util.List;

@WebService
public class FilmTextWs {
    FilmTextServices services = new FilmTextServices();

    public List<FilmTextDto> getFilmTexts(){
        return services.getFilmTexts();
    }


    public String createFilmText(FilmTextDto filmDto){
        FilmTextDto newFilmText = services.createFilmText(filmDto);
        if (newFilmText == null)   return "failed";
        return "success";
    }

    public FilmTextDto getFilmText(@WebParam(name = "id") int id){
        FilmTextDto countryById = services.getFilmTextById(id);
        return countryById;
    }

    public String updateFilmText(@WebParam(name = "id") int id,FilmTextDto countryDto) {
        FilmTextDto dto = services.updateFilmText(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }


}
