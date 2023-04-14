package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.Customer} entity
 */
public class CustomerDto implements Serializable {
    private  Integer id;
    @NotNull
    private  StoreDto store;
    @Size(max = 45)
    @NotNull
    private  String firstName;
    @Size(max = 45)
    @NotNull
    private  String lastName;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  AddressDto address;
    @NotNull
    private  Boolean active;
    @NotNull
    private  Instant createDate;
    private  Instant lastUpdate;
    private  Set<PaymentDto> payments;
    private  Set<RentalDto> rentals;

    public CustomerDto(Integer id, StoreDto store, String firstName, String lastName, String email, AddressDto address, Boolean active, Instant createDate, Instant lastUpdate, Set<PaymentDto> payments, Set<RentalDto> rentals) {
        this.id = id;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
        this.rentals = rentals;
    }

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public StoreDto getStore() {
        return store;
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

    public AddressDto getAddress() {
        return address;
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

    public Set<PaymentDto> getPayments() {
        return payments;
    }

    public Set<RentalDto> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto entity = (CustomerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.store, entity.store) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.createDate, entity.createDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.payments, entity.payments) &&
                Objects.equals(this.rentals, entity.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, store, firstName, lastName, email, address, active, createDate, lastUpdate, payments, rentals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "store = " + store + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "address = " + address + ", " +
                "active = " + active + ", " +
                "createDate = " + createDate + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "payments = " + payments + ", " +
                "rentals = " + rentals + ")";
    }
}