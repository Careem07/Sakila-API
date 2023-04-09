package org.iti.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import org.iti.entities.Actor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.entities.FilmActor} entity
 */
public class FilmActorDto implements Serializable {
    private  int id;


    private  FilmDto film;

    private Actor actor;
    @NotNull
    private  Instant lastUpdate;

    public FilmActorDto(int id, FilmDto film, Actor actor, Instant lastUpdate) {
        this.id = id;
        this.film = film;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }

    public FilmActorDto() {
    }

    public int getId() {
        return id;
    }

    public FilmDto getFilm() {
        return film;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorDto entity = (FilmActorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " + film + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}