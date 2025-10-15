package com.vehicle.service_api.application.port.output;

import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.VehicleStatus;

import java.util.List;
import java.util.Optional;

public interface VehicleRepositoryPort {
    Vehicle save(Vehicle v);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByStatus(VehicleStatus status);
}
