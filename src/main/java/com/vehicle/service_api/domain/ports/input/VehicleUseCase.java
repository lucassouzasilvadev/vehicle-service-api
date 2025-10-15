package com.vehicle.service_api.domain.ports.input;

import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.enums.VehicleStatus;

import java.util.List;


import java.util.List;

public interface VehicleUseCase {
    Vehicle create(Vehicle v);
    Vehicle findById(Long id);
    List<Vehicle> findAll();
    Vehicle update(Long id, Vehicle v);
    void delete(Long id);
    Vehicle updateStatus(Long id, VehicleStatus status);
}
