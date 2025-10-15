package com.vehicle.service_api.infrastructure.adapter.input.rest;

import com.vehicle.service_api.domain.model.Payment;
import com.vehicle.service_api.domain.ports.input.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentUseCase service;

    @PostMapping("/sale/{saleId}")
    public ResponseEntity<Payment> createForSale(@PathVariable Long saleId, @RequestParam BigDecimal amount) {
        return ResponseEntity.status(201).body(service.createForSale(saleId, amount));
    }

    @PostMapping("/{id}/approve")
    public Payment approve(@PathVariable Long id) {
        return service.approve(id);
    }

    @PostMapping("/{id}/reject")
    public Payment reject(@PathVariable Long id) {
        return service.reject(id);
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) {
        return service.findById(id);
    }
}
