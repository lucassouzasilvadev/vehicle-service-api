package com.vehicle.service_api.domain.ports.output;

import com.vehicle.service_api.domain.model.Vehicle;

import java.util.List;
import java.util.Optional;



public interface VehicleRepositoryPort {
    Vehicle save(Vehicle v);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findAll();
    void deleteById(Long id);
}
