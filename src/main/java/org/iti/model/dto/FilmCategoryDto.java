package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.model.entities.FilmCategory} entity
 */
@XmlRootElement
public class FilmCategoryDto implements Serializable {
    private Integer filmId;
    private Integer categoryId;
    private  FilmDto film;
    private CategoryDto categoryDto;
    @NotNull
    private Instant lastUpdate;

    public FilmCategoryDto(FilmDto film, CategoryDto categoryDto, Instant lastUpdate) {
        this.film = film;
        this.categoryDto = categoryDto;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryDto() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public FilmDto getFilm() {
        return film;
    }

    public void setFilm(FilmDto film) {
        this.film = film;
    }

    public CategoryDto getCategory() {
        return categoryDto;
    }

    public void setCategory(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryDto entity = (FilmCategoryDto) o;
        return Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "lastUpdate = " + lastUpdate + ")";
    }
}