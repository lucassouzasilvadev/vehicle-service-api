package com.vehicle.service_api.infrastructure.adapter.output.jpa.repo;


import com.vehicle.service_api.infrastructure.adapter.output.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findBySaleId(Long saleId);
}
