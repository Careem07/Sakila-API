package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.entities.Payment} entity
 */
public class PaymentDto implements Serializable {
    private  Integer id;
    @NotNull
    private  BigDecimal amount;
    @NotNull
    private  Instant paymentDate;
    private  Instant lastUpdate;
    private StaffDto staff;
    private CustomerDto customer;

    private RentalDto rental;

    public PaymentDto(Integer id, BigDecimal amount, Instant paymentDate, Instant lastUpdate, StaffDto staff, CustomerDto customer, RentalDto rental) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
        this.staff = staff;
        this.customer = customer;
        this.rental = rental;
    }

    public PaymentDto() {
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto entity = (PaymentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.paymentDate, entity.paymentDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, paymentDate, lastUpdate);
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", lastUpdate=" + lastUpdate +
                ", staff=" + staff +
                ", customer=" + customer +
                ", rental=" + rental +
                '}';
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public RentalDto getRental() {
        return rental;
    }

    public void setRental(RentalDto rental) {
        this.rental = rental;
    }
}