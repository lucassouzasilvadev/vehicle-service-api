package com.vehicle.service_api.application.service;

import com.vehicle.service_api.domain.model.Customer;
import com.vehicle.service_api.domain.ports.input.CustomerUseCase;
import com.vehicle.service_api.domain.ports.output.CustomerRepositoryPort;
import com.vehicle.service_api.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
    private final CustomerRepositoryPort repo;

    @Override
    public Customer create(Customer c) { return repo.save(c); }

    @Override
    public Customer findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
    }

    @Override
    public List<Customer> findAll() { return repo.findAll(); }

    @Override
    public Customer update(Long id, Customer c) {
        Customer ex = findById(id);
        ex.setName(c.getName()); ex.setCpf(c.getCpf()); ex.setEmail(c.getEmail()); ex.setPhone(c.getPhone());
        return repo.save(ex);
    }

    @Override
    public void delete(Long id) { repo.deleteById(id); }
}
