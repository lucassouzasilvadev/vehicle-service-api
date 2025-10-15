package com.vehicle.service_api.application.saga;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class SagaEvent {
    private final String type;
    private final Long entityId;
}