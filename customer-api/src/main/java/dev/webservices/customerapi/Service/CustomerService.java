package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.customerslib.Entity.Customer;

public interface CustomerService {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    void update(Customer customer);

    void delete(Long id);

}
