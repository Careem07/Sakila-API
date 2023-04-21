package org.iti.model.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Inventory} entity
 */
@XmlRootElement
public class InventoryDto implements Serializable {
    private  Integer id;
    @NotNull
    private  FilmDto film;
    private StoreDto store;
    @NotNull
    private  Instant lastUpdate;
    private  Set<RentalDto> rentals;

    public InventoryDto(Integer id, FilmDto film, StoreDto store, Instant lastUpdate, Set<RentalDto> rentals) {
        this.id = id;
        this.film = film;
        this.store = store;
        this.lastUpdate = lastUpdate;
        this.rentals = rentals;
    }

    public InventoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public FilmDto getFilm() {
        return film;
    }

    public void setFilm(FilmDto film) {
        this.film = film;
    }

    public StoreDto getStore() {
        return store;
    }

    public void setStore(StoreDto store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDto entity = (InventoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.rentals, entity.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, lastUpdate, rentals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " + film + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "rentals = " + rentals + ")";
    }


}