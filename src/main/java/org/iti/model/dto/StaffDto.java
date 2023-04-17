package org.iti.model.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link StaffDto} entity
 */
public class StaffDto implements Serializable {
    private Short id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    private AddressDto address;
    @JsonbTransient
    private byte[] picture;
    @Size(max = 50)
    private String email;
    @NotNull
    private Boolean active;
    @Size(max = 16)
    @NotNull
    private String username;
    @Size(max = 40)
    private String password;
    @NotNull
    private Instant lastUpdate;
    private Set<PaymentDto> payments;

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

    public StaffDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

//    public Set<PaymentDto> getPayments() {
//        return payments;
//    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

//    public void setPayments(Set<PaymentDto> payments) {
//        this.payments = payments;
//    }

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