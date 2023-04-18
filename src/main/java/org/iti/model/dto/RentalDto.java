package org.iti.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.iti.model.entities.Rental} entity
 */
@XmlRootElement
public class RentalDto implements Serializable {
    private  Integer id;
    @NotNull
    private  Instant rentalDate;
    private  Instant returnDate;
    private InventoryDto inventory;
    private CustomerDto customer;
    private StaffDto staff;
    private PaymentDto payment;
    @NotNull
    private  Instant lastUpdate;

    public RentalDto(Integer id, Instant rentalDate, Instant returnDate, InventoryDto inventory, CustomerDto customer, StaffDto staff, PaymentDto payment, Instant lastUpdate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.inventory = inventory;
        this.customer = customer;
        this.staff = staff;
        this.payment = payment;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Instant rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    //    public InventoryDto getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(InventoryDto inventory) {
//        this.inventory = inventory;
//    }

    public RentalDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDto entity = (RentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.rentalDate, entity.rentalDate) &&
                Objects.equals(this.returnDate, entity.returnDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, returnDate, lastUpdate);
    }

    @Override
    public String toString() {
        return "RentalDto{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", inventory=" + inventory +
                ", customer=" + customer +
                ", staff=" + staff +
                ", payment=" + payment +
                ", lastUpdate=" + lastUpdate +
                '}';
    }


}