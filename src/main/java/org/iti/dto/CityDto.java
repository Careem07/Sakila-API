package org.iti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.City} entity
 */
public class CityDto implements Serializable {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private  String city;
    @NotNull
    private  Instant lastUpdate;
    private  Set<AddressDto> addresses;

    public CityDto(Integer id, String city, Instant lastUpdate, Set<AddressDto> addresses) {
        this.id = id;
        this.city = city;
        this.lastUpdate = lastUpdate;
        this.addresses = addresses;
    }

    public CityDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto entity = (CityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.addresses, entity.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, lastUpdate, addresses);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "city = " + city + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "addresses = " + addresses + ")";
    }
}