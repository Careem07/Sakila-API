package org.iti.services;


import org.iti.model.dto.CategoryDto;

import org.iti.model.entities.Category;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class CategoryServices {
    static RepositoryImpl<Category> repo = new RepositoryImpl<>(Category.class);


    public CategoryDto createCategory(CategoryDto categoryDto){
        categoryDto.setLastUpdate(Instant.now());
        Category category = new ModelMapper().map(categoryDto,Category.class);
        if(repo.create(category) == null){
            return null;
        }
        return categoryDto;
    }

    public CategoryDto getCategoryById(int id){
        Category category = repo.findById(id);
        if (category == null) return null;
        return new ModelMapper().map(category,CategoryDto.class);
    }

    public List<CategoryDto> getCategories(){
        List<Category> categories = repo.findAll();
        return new ModelMapper().map(categories,new TypeToken<List<CategoryDto>>(){}.getType());
    }

    public boolean removeCategory(int id){
        Category category = repo.findById(id);
        return repo.remove(category);
    }

    public CategoryDto updateCategory(int id , CategoryDto categoryDto){
        Category category = repo.findById(id);
        category.setName(categoryDto.getName());
        category.setLastUpdate(categoryDto.getLastUpdate());
        Category newCategory = repo.update(category);
        return new ModelMapper().map(newCategory , CategoryDto.class);
    }
}
