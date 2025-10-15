package com.vehicle.service_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String color;
    private BigDecimal price;
    private VehicleStatus vehicleStatus;

    public void updateStatus(VehicleStatus newVehicleStatus){
        this.vehicleStatus = newVehicleStatus;
    }
}
