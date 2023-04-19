package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Customer} entity
 */
@XmlRootElement
public class CustomerDto implements Serializable {
    private  Integer id;
    @Size(max = 45)
    @NotNull
    private  String firstName;
    @Size(max = 45)
    @NotNull
    private  String lastName;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  Boolean active;
    @NotNull
    private  Instant createDate;
    private  Instant lastUpdate;
    private AddressDto address;
    private StoreDto store;



    public CustomerDto(Integer id, StoreDto store, String firstName, String lastName, String email, AddressDto address, Boolean active, Instant createDate, Instant lastUpdate, Set<PaymentDto> payments, Set<RentalDto> rentals) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;


    }

    public CustomerDto() {
    }


    public StoreDto getStore() {
        return store;
    }

    public void setStore(StoreDto store) {
        this.store = store;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }





    public Integer getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public Boolean getActive() {
        return active;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto entity = (CustomerDto) o;
        return Objects.equals(this.id, entity.id) &&

                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&

                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.createDate, entity.createDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, active, createDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +

                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +

                "active = " + active + ", " +
                "createDate = " + createDate + ", " +
                "lastUpdate = " + lastUpdate + ", " +

                ")";
    }
}