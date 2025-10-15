package com.vehicle.service_api.infrastructure.adapter.output.output.jpa;

import com.vehicle.service_api.domain.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public VehicleEntity toEntity(Vehicle vehicle) {
        return VehicleEntity.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufactureYear(vehicle.getYear())
                .color(vehicle.getColor())
                .price(vehicle.getPrice())
                .vehicleStatus(vehicle.getVehicleStatus())
                .build();
    }

    public Vehicle toDomain(VehicleEntity vehicleEntity) {
        return Vehicle.builder()
                .brand(vehicleEntity.getBrand())
                .model(vehicleEntity.getModel())
                .year(vehicleEntity.getManufactureYear())
                .color(vehicleEntity.getColor())
                .price(vehicleEntity.getPrice())
                .vehicleStatus(vehicleEntity.getVehicleStatus())
                .build();
    }
}
