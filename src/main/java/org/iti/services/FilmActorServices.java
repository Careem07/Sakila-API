package org.iti.services;

import org.iti.model.dto.FilmActorDto;
import org.iti.model.entities.FilmActor;
import org.iti.model.entities.FilmActorId;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class FilmActorServices {

    RepositoryImpl<FilmActor> repository = new RepositoryImpl<>(FilmActor.class);

    public FilmActorDto createFilmActor(FilmActorDto filmactorDto){
        filmactorDto.setLastUpdate(Instant.now());
        FilmActor filmactor = new ModelMapper().map(filmactorDto,FilmActor.class);
        if(repository.create(filmactor) == null){
            return null;
        }
        return filmactorDto;
    }
    public FilmActorDto getFilmActorByActor_Film(int id1, int id2) {
        FilmActorId actorId = new FilmActorId(id1,id2);
        FilmActor filmactor = repository.find(actorId);
        System.out.println("filmactor = " + filmactor);
        if (filmactor == null) return null;
        return new ModelMapper().map(filmactor,FilmActorDto.class);
    }

    public List<FilmActorDto> getFilmActors(){
        List<FilmActor> filmactor = repository.findAll();
        return new ModelMapper().map(filmactor,new TypeToken<List<FilmActorDto>>(){}.getType());
    }

    public boolean removeFilmActor(int id){
        FilmActor filmactor = repository.findById(id);
        return repository.remove(filmactor);
    }

    public FilmActorDto updateFilmActor(int id , FilmActorDto filmactorDto){
        FilmActor filmactor = repository.findById(id);

        FilmActor newFilmActor = repository.update(filmactor);
        return new ModelMapper().map(newFilmActor , FilmActorDto.class);
    }


}
