package com.vehicle.service_api.infrastructure.adapter.output.jpa;

import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.ports.output.VehicleRepositoryPort;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper.VehicleMapper;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.repo.VehicleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleRepositoryAdapter implements VehicleRepositoryPort {

    private final VehicleJpaRepository repo;

    @Override
    public Vehicle save(Vehicle v) {
        var saved = repo.save(VehicleMapper.toEntity(v));
        return VehicleMapper.toDomain(saved);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return repo.findById(id).map(VehicleMapper::toDomain);
    }

    @Override
    public List<Vehicle> findAll() {
        return repo.findAll().stream().map(VehicleMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) { repo.deleteById(id); }
}

