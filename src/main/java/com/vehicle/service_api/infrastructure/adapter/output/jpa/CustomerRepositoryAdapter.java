package com.vehicle.service_api.infrastructure.adapter.output.jpa;


import com.vehicle.service_api.domain.model.Customer;
import com.vehicle.service_api.domain.ports.output.CustomerRepositoryPort;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper.CustomerMapper;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.repo.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {
    private final CustomerJpaRepository repo;

    @Override
    public Customer save(Customer c) {
        var saved = repo.save(CustomerMapper.toEntity(c));
        return CustomerMapper.toDomain(saved);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repo.findById(id).map(CustomerMapper::toDomain);
    }

    @Override
    public List<Customer> findAll() {
        return repo.findAll().stream().map(CustomerMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

