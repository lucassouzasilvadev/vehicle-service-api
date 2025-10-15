package com.vehicle.service_api.application.saga;


import com.vehicle.service_api.application.saga.events.PaymentCompletedEvent;
import com.vehicle.service_api.application.saga.events.SaleCancelledEvent;
import com.vehicle.service_api.application.saga.events.SaleCreatedEvent;
import com.vehicle.service_api.application.service.PaymentService;
import com.vehicle.service_api.application.service.SaleService;
import com.vehicle.service_api.application.service.VehicleService;
import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.domain.model.enums.SaleStatus;
import com.vehicle.service_api.domain.model.enums.VehicleStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SagaOrchestrator {
    private final VehicleService vehicleService;
    private final PaymentService paymentService;
    private final SaleService saleService;

    @EventListener
    public void onSaleCreated(SaleCreatedEvent event) {
        Sale sale = saleService.findById(event.getEntityId());
        vehicleService.updateStatus(sale.getVehicleId(), VehicleStatus.RESERVED);
        paymentService.createForSale(sale.getId(), sale.getTotalAmount());
    }

    @EventListener
    public void onPaymentCompleted(PaymentCompletedEvent event) {
        var payment = paymentService.findById(event.getEntityId());
        var sale = saleService.findById(payment.getSaleId());
        saleService.updateStatus(sale.getId(), SaleStatus.PAID);
    }

    @EventListener
    public void handleSaleCancelled(SaleCancelledEvent event) {
        paymentService.cancelBySaleId(event.getEntityId());
        Sale sale = saleService.findById(event.getEntityId());
        vehicleService.updateStatus(sale.getVehicleId(), VehicleStatus.AVAILABLE);
    }

}
