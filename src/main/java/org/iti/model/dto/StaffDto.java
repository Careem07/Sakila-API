package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.Staff} entity
 */
public class StaffDto implements Serializable {
    private  Short id;
    @Size(max = 45)
    @NotNull
    private  String firstName;
    @Size(max = 45)
    @NotNull
    private  String lastName;
    @NotNull
    private  AddressDto address;
    private  byte[] picture;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  Boolean active;
    @Size(max = 16)
    @NotNull
    private  String username;
    @Size(max = 40)
    private  String password;
    @NotNull
    private  Instant lastUpdate;
    private  Set<PaymentDto> payments;

    public StaffDto(Short id, String firstName, String lastName, AddressDto address, byte[] picture, String email, Boolean active, String username, String password, Instant lastUpdate, Set<PaymentDto> payments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
    }

    public StaffDto() {
    }

    public Short getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<PaymentDto> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDto entity = (StaffDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.picture, entity.picture) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.payments, entity.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, picture, email, active, username, password, lastUpdate, payments);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "address = " + address + ", " +
                "picture = " + picture + ", " +
                "email = " + email + ", " +
                "active = " + active + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "payments = " + payments + ")";
    }
}