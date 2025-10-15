package com.vehicle.service_api.infrastructure.adapter.output.jpa;


import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.domain.ports.output.SaleRepositoryPort;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper.SaleMapper;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.repo.SaleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SaleRepositoryAdapter implements SaleRepositoryPort {
    private final SaleJpaRepository repo;

    @Override
    public Sale save(Sale s) {
        var saved = repo.save(SaleMapper.toEntity(s));
        return SaleMapper.toDomain(saved);
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return repo.findById(id).map(SaleMapper::toDomain);
    }

    @Override
    public List<Sale> findAll() {
        return repo.findAll().stream().map(SaleMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
