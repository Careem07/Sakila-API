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
    private int actorId;

    private int filmId;

    private  FilmDto film;

    private ActorDto actor;
    @NotNull
    private  Instant lastUpdate;

    public FilmActorDto() {
    }


    public FilmActorDto(int actorId, int filmId, FilmDto film, ActorDto actor, Instant lastUpdate) {
        this.actorId = actorId;
        this.filmId = filmId;
        this.film = film;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }

//    public int getActorId() {
//        return actorId;
//    }

//    public void setActorId(int actorId) {
//        this.actorId = actorId;
//    }

//    public int getFilmId() {
//        return filmId;
//    }

//    public void setFilmId(int filmId) {
//        this.filmId = filmId;
//    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public ActorDto getActor() {
        return actor;
    }

    public void setActor(ActorDto actor) {
        this.actor = actor;
    }

    public FilmDto getFilm() {
        return film;
    }

    public void setFilm(FilmDto film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "FilmActorDto{" +
                "actorId=" + actorId +
                ", filmId=" + filmId +
                ", film=" + film +
                ", actor=" + actor +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}