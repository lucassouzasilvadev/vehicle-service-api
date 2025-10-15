package com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper;


import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.infrastructure.adapter.output.entities.SaleEntity;

public class SaleMapper {
    public static SaleEntity toEntity(Sale s) {
        if (s == null) return null;
        return SaleEntity.builder()
                .id(s.getId())
                .vehicleId(s.getVehicleId())
                .customerId(s.getCustomerId())
                .totalAmount(s.getTotalAmount())
                .saleDate(s.getSaleDate())
                .status(s.getStatus())
                .build();
    }

    public static Sale toDomain(SaleEntity e) {
        if (e == null) return null;
        return Sale.builder()
                .id(e.getId())
                .vehicleId(e.getVehicleId())
                .customerId(e.getCustomerId())
                .totalAmount(e.getTotalAmount())
                .saleDate(e.getSaleDate())
                .status(e.getStatus())
                .build();
    }
}
