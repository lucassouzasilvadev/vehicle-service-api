package com.vehicle.service_api.domain.ports.input;


import com.vehicle.service_api.domain.model.Customer;

import java.util.List;

public interface CustomerUseCase {
    Customer create(Customer c);
    Customer findById(Long id);
    List<Customer> findAll();
    Customer update(Long id, Customer c);
    void delete(Long id);
}

