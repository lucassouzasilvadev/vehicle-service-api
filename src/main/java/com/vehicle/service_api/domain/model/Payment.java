package com.vehicle.service_api.domain.model;


import com.vehicle.service_api.domain.model.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private Long saleId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private PaymentStatus status;
}
