package com.vehicle.service_api.infrastructure.adapter.input.web;

import com.vehicle.service_api.application.port.input.VehicleUseCase;
import com.vehicle.service_api.domain.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleUseCase vehicleUseCase;


    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleUseCase.create(vehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleUseCase.update(id, vehicle));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> updateStatus(@PathVariable Long id, @RequestParam String newStatus) {
        return ResponseEntity.ok(vehicleUseCase.updateVehicleStatus(id, newStatus));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Vehicle>> findAvailable() {
        return ResponseEntity.ok(vehicleUseCase.findAvailable());
    }

    @GetMapping("/sold")
    public ResponseEntity<List<Vehicle>> findSold() {
        return ResponseEntity.ok(vehicleUseCase.findSold());
    }

}
