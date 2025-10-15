package com.vehicle.service_api.application.saga.events;

import com.vehicle.service_api.application.saga.SagaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class SaleCancelledEvent extends SagaEvent {
    public SaleCancelledEvent(Long saleId) {
        super("SALE_CANCELED", saleId);
    }
}
