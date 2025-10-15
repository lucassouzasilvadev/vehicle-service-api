package com.vehicle.service_api.infrastructure.adapter.output.output.jpa;

import com.vehicle.service_api.application.port.output.VehicleRepositoryPort;
import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.VehicleStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleJpaAdapter implements VehicleRepositoryPort {

    private final VehicleRepository repository;

    private final VehicleMapper vehicleMapper;


    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleMapper.toDomain(repository.save(vehicleMapper.toEntity(vehicle)));
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id).map(vehicleMapper::toDomain);
    }

    @Override
    public List<Vehicle> findByStatus(VehicleStatus status) {
        return repository
                .findByVehicleStatusOrderByPriceAsc(status)
                .stream()
                .map(vehicleMapper::toDomain)
                .toList();
    }
}
