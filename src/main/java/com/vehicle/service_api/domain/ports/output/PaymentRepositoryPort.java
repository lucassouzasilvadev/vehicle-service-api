package com.vehicle.service_api.domain.ports.output;

import com.vehicle.service_api.domain.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepositoryPort {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    List<Payment> findAll();
    void deleteById(Long id);
    Optional<Payment> findBySaleId(Long saleId);
}
