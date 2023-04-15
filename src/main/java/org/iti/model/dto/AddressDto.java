package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.model.entities.Address} entity
 */
@XmlRootElement
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


    public AddressDto(Integer id, String address, String address2, String district, String postalCode, String phone, Instant lastUpdate) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;

    }

    public AddressDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
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
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, postalCode, phone, lastUpdate);
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
                "lastUpdate = " + lastUpdate ;}
}