package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Country} entity
 */
@XmlRootElement
public class CountryDto implements Serializable {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private  String country;
    @NotNull
    private  Instant lastUpdate;
    private  Set<CityDto> cities;

    public CountryDto(Integer id, String country, Instant lastUpdate, Set<CityDto> cities) {
        this.id = id;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }

    public CountryDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<CityDto> getCities() {
        return cities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCities(Set<CityDto> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto entity = (CountryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.cities, entity.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, lastUpdate, cities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "country = " + country + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "cities = " + cities + ")";
    }
}