package com.vehicle.service_api.application.service;

import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.enums.VehicleStatus;
import com.vehicle.service_api.domain.ports.input.VehicleUseCase;
import com.vehicle.service_api.domain.ports.output.VehicleRepositoryPort;
import com.vehicle.service_api.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements VehicleUseCase {
    private final VehicleRepositoryPort repo;

    @Override
    public Vehicle create(Vehicle v) {
        if (v.getStatus() == null) v.setStatus(VehicleStatus.AVAILABLE);
        return repo.save(v);
    }

    @Override
    public Vehicle findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found: " + id));
    }

    @Override
    public List<Vehicle> findAll() { return repo.findAll(); }

    @Override
    public Vehicle update(Long id, Vehicle v) {
        Vehicle ex = findById(id); ex.updateFrom(v); return repo.save(ex);
    }

    @Override
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Vehicle updateStatus(Long id, VehicleStatus status) {
        Vehicle ex = findById(id); ex.setStatus(status); return repo.save(ex);
    }
}
