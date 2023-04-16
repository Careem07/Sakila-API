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
    private Integer id;
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

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FilmDto getFilm() {
        return film;
    }

    public void setFilm(FilmDto film) {
        this.film = film;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
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