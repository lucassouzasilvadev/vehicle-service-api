package com.vehicle.service_api.application.saga;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SagaEventPublisher {
    private final ApplicationEventPublisher publisher;
    public void publish(SagaEvent event) { publisher.publishEvent(event); }
}