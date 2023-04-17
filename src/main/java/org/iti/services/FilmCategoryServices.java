package org.iti.services;

import org.iti.model.dto.FilmCategoryDto;
import org.iti.model.entities.FilmCategory;
import org.iti.model.entities.FilmCategoryId;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class FilmCategoryServices {

    RepositoryImpl<FilmCategory> repository = new RepositoryImpl<>(FilmCategory.class);

    public FilmCategoryDto createFilmCategory(FilmCategoryDto filmCategoryDto){
        FilmCategory filmCategory = new ModelMapper().map(filmCategoryDto,FilmCategory.class);
        if(repository.create(filmCategory) == null){
            return null;
        }
        return filmCategoryDto;
    }
    public FilmCategoryDto getFilmCategoryByCategory_Film(int id1, int id2) {
        FilmCategoryId CategoryId = new FilmCategoryId(id1,id2);
        FilmCategory filmCategory = repository.find(CategoryId);
        System.out.println("filmCategory = " + filmCategory);
        if (filmCategory == null) return null;
        return new ModelMapper().map(filmCategory,FilmCategoryDto.class);
    }

    public List<FilmCategoryDto> getFilmCategories(){
        List<FilmCategory> filmCategory = repository.findAll();
        return new ModelMapper().map(filmCategory,new TypeToken<List<FilmCategoryDto>>(){}.getType());
    }

    public boolean removeFilmCategory(int id){
        FilmCategory filmCategory = repository.findById(id);
        return repository.remove(filmCategory);
    }

    public FilmCategoryDto updateFilmCategory(int id , FilmCategoryDto filmCategoryDto){
        FilmCategory filmCategory = repository.findById(id);

        FilmCategory newFilmCategory = repository.update(filmCategory);
        return new ModelMapper().map(newFilmCategory , FilmCategoryDto.class);
    }

}
