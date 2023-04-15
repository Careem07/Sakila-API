package org.iti.model.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Store} entity
 */
@XmlRootElement
public class StoreDto implements Serializable {
    private Short id;
    @NotNull
    private StaffDto managerStaff;
    @NotNull
    private AddressDto address;
    @NotNull
    private Instant lastUpdate;
    @JsonbTransient
    private Set<InventoryDto> inventories;
    @JsonbTransient
    private Set<StaffDto> staff;
    @JsonbTransient
    private Set<CustomerDto> customers;

    public StoreDto(Short id, StaffDto managerStaff, AddressDto address, Instant lastUpdate, Set<InventoryDto> inventories, Set<StaffDto> staff, Set<CustomerDto> customers) {
        this.id = id;
        this.managerStaff = managerStaff;
        this.address = address;
        this.lastUpdate = lastUpdate;
        this.inventories = inventories;
        this.staff = staff;
        this.customers = customers;
    }

    public StoreDto() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public StaffDto getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffDto managerStaff) {
        this.managerStaff = managerStaff;
    }
//
//    public AddressDto getAddress() {
//        return address;
//    }
//
//    public void setAddress(AddressDto address) {
//        this.address = address;
//    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

//    public Set<InventoryDto> getInventories() {
//        return inventories;
//    }
//
//    public void setInventories(Set<InventoryDto> inventories) {
//        this.inventories = inventories;
//    }

//    public Set<StaffDto> getStaff() {
//        return staff;
//    }

//    public void setStaff(Set<StaffDto> staff) {
//        this.staff = staff;
//    }

//    public Set<CustomerDto> getCustomers() {
//        return customers;
//    }

//    public void setCustomers(Set<CustomerDto> customers) {
//        this.customers = customers;
//    }
}