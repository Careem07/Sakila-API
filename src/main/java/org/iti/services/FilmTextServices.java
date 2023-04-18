package org.iti.services;

import org.iti.model.dto.FilmTextDto;
import org.iti.model.entities.FilmText;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class FilmTextServices {

    static RepositoryImpl<FilmText> repo = new RepositoryImpl<>(FilmText.class);


    public FilmTextDto createFilmText(FilmTextDto FilmTextDto) {

        FilmText FilmText = new ModelMapper().map(FilmTextDto, FilmText.class);
        if (repo.create(FilmText) == null) {
            return null;
        }
        return FilmTextDto;
    }

    public FilmTextDto getFilmTextById(int id) {
        FilmText filmText = repo.findById(id);
        if (filmText == null) return null;
        return new ModelMapper().map(filmText, FilmTextDto.class);
    }

    public List<FilmTextDto> getFilmTexts(){
        List<FilmText> filmTexts = repo.findAll();
        return new ModelMapper().map(filmTexts,new TypeToken<List<FilmTextDto>>(){}.getType());
    }


    public boolean removeFilmText(int id) {
        FilmText filmText = repo.findById(id);
        return repo.remove(filmText);
    }
    public FilmTextDto updateFilmText(int id , FilmTextDto filmTextDto){

        FilmText filmText = repo.findById(id);
        filmText.setDescription(filmTextDto.getDescription());
        filmText.setTitle(filmTextDto.getTitle());
        FilmText newFilmText = repo.update(filmText);
        return new ModelMapper().map(newFilmText,FilmTextDto.class);
    }

}
