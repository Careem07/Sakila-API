package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.FilmDto;
import org.iti.services.FilmServices;

import java.util.List;

@WebService
public class FilmWs {

    FilmServices services = new FilmServices();

    public List<FilmDto> getFilms(){
        return services.getFilms();
    }


    public String createFilm(FilmDto filmDto){
        FilmDto newFilm = services.createFilm(filmDto);
        if (newFilm == null)   return "failed";
        return "success";
    }

    public FilmDto getFilm(@WebParam(name = "id") int id){
        FilmDto countryById = services.getFilmById(id);
        return countryById;
    }

    public String updateFilm(@WebParam(name = "id") int id,FilmDto countryDto) {
        FilmDto dto = services.updateFilm(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}
