package com.vehicle.service_api.domain.model;

import com.vehicle.service_api.domain.model.enums.SaleStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Long vehicleId;
    private Long customerId;
    private BigDecimal totalAmount;
    private LocalDateTime saleDate;
    private SaleStatus status;
}
