package com.vehicle.service_api.application.service;

import com.vehicle.service_api.application.port.input.VehicleUseCase;
import com.vehicle.service_api.application.port.output.VehicleRepositoryPort;
import com.vehicle.service_api.domain.exception.BusinessException;
import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.VehicleStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements VehicleUseCase {

    private final VehicleRepositoryPort vehicleRepository;

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicle.updateStatus(VehicleStatus.AVAILABLE);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle findVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Vehicle not found"));
        findVehicle.setBrand(vehicle.getBrand());
        findVehicle.setModel(vehicle.getModel());
        findVehicle.setYear(vehicle.getYear());
        findVehicle.setPrice(vehicle.getPrice());
        findVehicle.setColor(vehicle.getColor());
        return vehicleRepository.save(findVehicle);
    }

    @Override
    public List<Vehicle> findAvailable() {
        return vehicleRepository.findByStatus(VehicleStatus.AVAILABLE);
    }

    @Override
    public List<Vehicle> findSold() {
        return vehicleRepository.findByStatus(VehicleStatus.SOLD);
    }

    @Override
    public Vehicle updateVehicleStatus(Long id, String newStatus) {
        Vehicle findVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Vehicle not found"));
        findVehicle.updateStatus(VehicleStatus.valueOf(newStatus));
        return vehicleRepository.save(findVehicle);
    }
}
