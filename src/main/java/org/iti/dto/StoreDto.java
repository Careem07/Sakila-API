package org.iti.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.entities.Store} entity
 */
public class StoreDto implements Serializable {
    private final Short id;
    @NotNull
    private final AddressDto address;
    @NotNull
    private final Instant lastUpdate;
    private final Set<InventoryDto> inventories;
    private final Set<StaffDto> staff;
    private final Set<CustomerDto> customers;

    public StoreDto(Short id, AddressDto address, Instant lastUpdate, Set<InventoryDto> inventories, Set<StaffDto> staff, Set<CustomerDto> customers) {
        this.id = id;
        this.address = address;
        this.lastUpdate = lastUpdate;
        this.inventories = inventories;
        this.staff = staff;
        this.customers = customers;
    }

    public Short getId() {
        return id;
    }

    public AddressDto getAddress() {
        return address;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Set<InventoryDto> getInventories() {
        return inventories;
    }

    public Set<StaffDto> getStaff() {
        return staff;
    }

    public Set<CustomerDto> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDto entity = (StoreDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.inventories, entity.inventories) &&
                Objects.equals(this.staff, entity.staff) &&
                Objects.equals(this.customers, entity.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, lastUpdate, inventories, staff, customers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "inventories = " + inventories + ", " +
                "staff = " + staff + ", " +
                "customers = " + customers + ")";
    }
}