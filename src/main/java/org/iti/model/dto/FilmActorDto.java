package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.iti.model.entities.Actor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.model.entities.FilmActor} entity
 */
@XmlRootElement
public class FilmActorDto implements Serializable {
    private  int id;


    private  FilmDto film;

    private ActorDto actor;
    @NotNull
    private  Instant lastUpdate;

    public FilmActorDto(int id, FilmDto film, ActorDto actor, Instant lastUpdate) {
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

//    public FilmDto getFilm() {
//        return film;
//    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

//    public ActorDto getActor() {
//        return actor;
//    }
//
//    public void setActor(ActorDto actor) {
//        this.actor = actor;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorDto entity = (FilmActorDto) o;
        return Objects.equals(this.id, entity.id) &&
                //Objects.equals(this.film, entity.film) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " +  " " +
                "lastUpdate = " + lastUpdate + ")";
    }
}