package com.vehicle.service_api.application.saga.events;

import com.vehicle.service_api.application.saga.SagaEvent;

public class SaleCreatedEvent extends SagaEvent {
    public SaleCreatedEvent(Long saleId) {
        super("SALE_CREATED", saleId);
    }
}