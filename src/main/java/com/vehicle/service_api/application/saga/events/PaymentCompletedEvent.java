package com.vehicle.service_api.application.saga.events;

import com.vehicle.service_api.application.saga.SagaEvent;

public class PaymentCompletedEvent extends SagaEvent {
    public PaymentCompletedEvent(Long paymentId) {
        super("PAYMENT_COMPLETED", paymentId);
    }
}