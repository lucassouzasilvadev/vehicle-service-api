package com.vehicle.service_api.infrastructure.adapter.output.entities;

import com.vehicle.service_api.domain.model.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_vehicle")
public class VehicleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;

    @Column(name = "manufacture_year")
    private int year;

    private String color;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;
}
