package com.vehicle.service_api.infrastructure.adapter.input.rest;


import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.domain.model.enums.SaleStatus;
import com.vehicle.service_api.domain.ports.input.SaleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleUseCase service;

    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody Sale s) {
        return ResponseEntity.status(201).body(service.create(s));
    }

    @GetMapping
    public List<Sale> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public Sale get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping("/{id}/status")
    public Sale updateStatus(@PathVariable Long id, @RequestParam SaleStatus status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Sale> cancel(@PathVariable Long id) {
        Sale sale = service.cancelSale(id);
        return ResponseEntity.ok(sale);
    }

}
