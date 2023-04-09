package org.iti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.entities.Address} entity
 */
public class AddressDto implements Serializable {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private  String address;
    @Size(max = 50)
    private  String address2;
    @Size(max = 20)
    @NotNull
    private  String district;
    @Size(max = 10)
    private  String postalCode;
    @Size(max = 20)
    @NotNull
    private  String phone;
    @NotNull
    private  Instant lastUpdate;
    private  Object location;

    public AddressDto(Integer id, String address, String address2, String district, String postalCode, String phone, Instant lastUpdate, Object location) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.location = location;
    }

    public AddressDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getDistrict() {
        return district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Object getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.address2, entity.address2) &&
                Objects.equals(this.district, entity.district) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.location, entity.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, postalCode, phone, lastUpdate, location);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "address2 = " + address2 + ", " +
                "district = " + district + ", " +
                "postalCode = " + postalCode + ", " +
                "phone = " + phone + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "location = " + location + ")";
    }
}