package com.vehicle.service_api.infrastructure.adapter.input.rest;


import com.vehicle.service_api.domain.model.Customer;
import com.vehicle.service_api.domain.ports.input.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerUseCase service;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) {
        return ResponseEntity.status(201).body(service.create(c));
    }

    @GetMapping
    public List<Customer> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer c) { return service.update(id, c); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

