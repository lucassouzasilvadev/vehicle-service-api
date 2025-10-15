package com.vehicle.service_api.application.port.input;

import com.vehicle.service_api.domain.model.Vehicle;
import java.util.List;

public interface VehicleUseCase {
    Vehicle create (Vehicle vehicle);
    Vehicle update (Long id, Vehicle vehicle);
    List<Vehicle> findAvailable();
    List<Vehicle> findSold();
    Vehicle updateVehicleStatus(Long id, String newStatus);
}
