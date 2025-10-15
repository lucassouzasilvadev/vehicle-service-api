package com.vehicle.service_api.domain.ports.input;



import com.vehicle.service_api.domain.model.Payment;

import java.math.BigDecimal;

public interface PaymentUseCase {
    Payment createForSale(Long saleId, BigDecimal amount);
    Payment approve(Long id);
    Payment reject(Long id);
    Payment findById(Long id);
}
