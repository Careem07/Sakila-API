package org.iti;

import org.iti.services.AddressServices;
import org.iti.services.CustomerServices;
import org.iti.services.StoreServices;

public class App {
    public static void main(String[] args) {
        AddressServices services = new AddressServices();
        services.getAddressById(1);
        CustomerServices services1 = new CustomerServices();
        services1.getCustomerById(1);
    }
}
