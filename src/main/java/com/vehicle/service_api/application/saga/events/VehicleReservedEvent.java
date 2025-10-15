package com.vehicle.service_api.application.saga.events;

import com.vehicle.service_api.application.saga.SagaEvent;

public class VehicleReservedEvent extends SagaEvent {
    public VehicleReservedEvent(Long vehicleId) {
        super("VEHICLE_RESERVED", vehicleId);
    }
}