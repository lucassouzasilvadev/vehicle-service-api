package com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper;


import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.infrastructure.adapter.output.entities.VehicleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleMapper {
    public static VehicleEntity toEntity(Vehicle v) {
        if (v == null) return null;
        return VehicleEntity.builder()
                .id(v.getId())
                .brand(v.getBrand())
                .model(v.getModel())
                .year(v.getYear())
                .color(v.getColor())
                .price(v.getPrice())
                .status(v.getStatus())
                .build();
    }
    public static Vehicle toDomain(VehicleEntity e) {
        if (e == null) return null;
        return Vehicle.builder()
                .id(e.getId())
                .brand(e.getBrand())
                .model(e.getModel())
                .year(e.getYear())
                .color(e.getColor())
                .price(e.getPrice())
                .status(e.getStatus())
                .build();
    }
}

