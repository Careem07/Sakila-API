package org.iti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.Category} entity
 */
public class CategoryDto implements Serializable {
    private  Short id;
    @Size(max = 25)
    @NotNull
    private  String name;
    @NotNull
    private  Instant lastUpdate;
    private  Set<FilmCategoryDto> filmCategories;

    public CategoryDto(Short id, String name, Instant lastUpdate, Set<FilmCategoryDto> filmCategories) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategories = filmCategories;
    }

    public CategoryDto() {
    }

    public Short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<FilmCategoryDto> getFilmCategories() {
        return filmCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.filmCategories, entity.filmCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastUpdate, filmCategories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "filmCategories = " + filmCategories + ")";
    }
}