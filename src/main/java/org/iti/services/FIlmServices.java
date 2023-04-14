package org.iti.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import org.iti.model.dto.FilmDto;

import org.iti.model.entities.Film;
import org.iti.model.entities.Film;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class FIlmServices {
    static RepositoryImpl<Film> repo = new RepositoryImpl<>(Film.class);


    public FilmDto createFilm(FilmDto filmDto) {

        Film film = new ModelMapper().map(filmDto, Film.class);
        if (repo.create(film) == null) {
            return null;
        }
        return filmDto;
    }

    public FilmDto getFilmById(int id) {
        Film film = repo.findById(id);
        System.out.println("film.getDescription() = " + film.getDescription());
        if (film == null) return null;
        return new ModelMapper().map(film, FilmDto.class);
    }

    public List<FilmDto> getFilms(){
        List<Film> films = repo.findAll();
        return new ModelMapper().map(films,new TypeToken<List<FilmDto>>(){}.getType());
    }


    public boolean removeFilm(int id) {
        Film film = repo.findById(id);
        return repo.remove(film);
    }
}
