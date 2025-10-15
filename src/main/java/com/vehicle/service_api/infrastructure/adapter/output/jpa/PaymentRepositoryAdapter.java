package com.vehicle.service_api.infrastructure.adapter.output.jpa;

import com.vehicle.service_api.domain.model.Payment;
import com.vehicle.service_api.domain.ports.output.PaymentRepositoryPort;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper.PaymentMapper;
import com.vehicle.service_api.infrastructure.adapter.output.jpa.repo.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepositoryPort {
    private final PaymentJpaRepository repo;

    @Override
    public Payment save(Payment p) {
        var saved = repo.save(PaymentMapper.toEntity(p));
        return PaymentMapper.toDomain(saved);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repo.findById(id).map(PaymentMapper::toDomain);
    }

    @Override
    public List<Payment> findAll() {
        return repo.findAll().stream().map(PaymentMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Payment> findBySaleId(Long saleId) {
        return Optional.empty();
    }
}
