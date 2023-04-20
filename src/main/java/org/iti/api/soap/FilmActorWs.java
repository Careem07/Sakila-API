package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.FilmActorDto;
import org.iti.services.FilmActorServices;

import java.util.List;

@WebService
public class FilmActorWs {

    FilmActorServices services = new FilmActorServices();

    public List<FilmActorDto> getFilmActors(){
        return services.getFilmActors();
    }


    public String createFilmActor(FilmActorDto filmActorDto){
        FilmActorDto newFilmActor = services.createFilmActor(filmActorDto);
        if (newFilmActor == null)   return "failed";
        return "success";
    }

    public FilmActorDto getFilmActor(@WebParam(name = "id") int id1 , @WebParam(name = "id2") int id2){
        FilmActorDto countryById = services.getFilmActorByActor_Film(id1 , id2);
        return countryById;
    }

    public String updateFilmActor(@WebParam(name = "id") int id,FilmActorDto countryDto) {
        FilmActorDto dto = services.updateFilmActor(id,countryDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }


}
