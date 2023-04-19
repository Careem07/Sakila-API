package org.iti.model.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.City} entity
 * To insert in this DTO unComment Country Setters/Getters
 */
@XmlRootElement
public class CityDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    @NotNull
    private CountryDto country;
    @NotNull
    private Instant lastUpdate;
    private Set<AddressDto> addresses = new LinkedHashSet<>();

    public CityDto(Integer id, String city, CountryDto country, Instant lastUpdate, Set<AddressDto> addresses) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.addresses = addresses;
    }

    public CityDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public CountryDto getCountry() {
//        return country;
//    }
//
//    public void setCountry(CountryDto country) {
//        this.country = country;
//    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }



}