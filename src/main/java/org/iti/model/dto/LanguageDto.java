package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Language} entity
 */
@XmlRootElement
public class LanguageDto implements Serializable {
    private  Short id;
    @Size(max = 20)
    @NotNull
    private  String name;
    @NotNull
    private  Instant lastUpdate;
    private  Set<FilmDto> films;

    public LanguageDto(Short id, String name, Instant lastUpdate, Set<FilmDto> films) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.films = films;
    }

    public LanguageDto() {
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

    public void setId(Short id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDto entity = (LanguageDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.films, entity.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastUpdate, films);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "films = " + films + ")";
    }
}