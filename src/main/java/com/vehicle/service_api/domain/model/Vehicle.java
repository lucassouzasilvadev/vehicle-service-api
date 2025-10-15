package com.vehicle.service_api.domain.model;

import com.vehicle.service_api.domain.model.enums.VehicleStatus;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private BigDecimal price;
    private VehicleStatus status;

    public void updateFrom(Vehicle v) {
        this.brand = v.brand;
        this.model = v.model;
        this.year = v.year;
        this.color = v.color;
        this.price = v.price;
        this.status = v.status;
    }
}
