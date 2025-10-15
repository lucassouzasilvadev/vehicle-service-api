package com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper;

import com.vehicle.service_api.domain.model.Payment;
import com.vehicle.service_api.infrastructure.adapter.output.entities.PaymentEntity;

public class PaymentMapper {
    public static PaymentEntity toEntity(Payment p) {
        if (p == null) return null;
        return PaymentEntity.builder()
                .id(p.getId())
                .saleId(p.getSaleId())
                .amount(p.getAmount())
                .status(p.getStatus())
                .createdAt(p.getCreatedAt())
                .build();
    }

    public static Payment toDomain(PaymentEntity e) {
        if (e == null) return null;
        return Payment.builder()
                .id(e.getId())
                .saleId(e.getSaleId())
                .amount(e.getAmount())
                .status(e.getStatus())
                .createdAt(e.getCreatedAt())
                .build();
    }
}
