package org.iti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.entities.FilmText} entity
 */
public class FilmTextDto implements Serializable {
    private  Short id;
    @Size(max = 255)
    @NotNull
    private  String title;
    private  String description;

    public FilmTextDto(Short id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public FilmTextDto() {
    }

    public Short getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextDto entity = (FilmTextDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "description = " + description + ")";
    }
}