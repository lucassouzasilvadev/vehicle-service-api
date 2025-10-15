package com.vehicle.service_api.infrastructure.adapter.output.output.jpa;

import com.vehicle.service_api.domain.model.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "tb_vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int manufactureYear;
    private String color;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;
}
