package com.vehicle.service_api.infrastructure.adapter.input.rest;


import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.enums.VehicleStatus;
import com.vehicle.service_api.domain.ports.input.VehicleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleUseCase service;

    @PostMapping public ResponseEntity<Vehicle> create(@RequestBody Vehicle v) {
        return ResponseEntity.status(201).body(service.create(v));
    }
    @GetMapping public List<Vehicle> list() { return service.findAll(); }
    @GetMapping("/{id}") public Vehicle get(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}") public Vehicle update(@PathVariable Long id, @RequestBody Vehicle v) { return service.update(id, v); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
    @PostMapping("/{id}/status") public Vehicle updateStatus(@PathVariable Long id, @RequestParam VehicleStatus status) {
        return service.updateStatus(id, status);
    }
}
