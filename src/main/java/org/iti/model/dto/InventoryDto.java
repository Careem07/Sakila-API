package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.Inventory} entity
 */
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

    public FilmDto getFilm() {
        return film;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<RentalDto> getRentals() {
        return rentals;
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

    public StoreDto getStore() {
        return store;
    }

    public void setStore(StoreDto store) {
        this.store = store;
    }
}