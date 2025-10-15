package com.vehicle.service_api.application.service;

import com.vehicle.service_api.application.saga.SagaEventPublisher;
import com.vehicle.service_api.application.saga.events.PaymentCompletedEvent;
import com.vehicle.service_api.domain.model.Payment;
import com.vehicle.service_api.domain.model.enums.PaymentStatus;
import com.vehicle.service_api.domain.ports.input.PaymentUseCase;
import com.vehicle.service_api.domain.ports.output.PaymentRepositoryPort;
import com.vehicle.service_api.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {
    private final PaymentRepositoryPort repo;
    private final SagaEventPublisher publisher;

    @Override
    public Payment createForSale(Long saleId, BigDecimal amount) {
        Payment p = Payment.builder()
                .saleId(saleId).amount(amount)
                .createdAt(LocalDateTime.now())
                .status(PaymentStatus.PENDING).build();
        return repo.save(p);
    }

    @Override
    public Payment approve(Long id) {
        Payment p = findById(id);
        p.setStatus(PaymentStatus.APPROVED);
        Payment saved = repo.save(p);
        publisher.publish(new PaymentCompletedEvent(saved.getId()));
        return saved;
    }

    @Override
    public Payment reject(Long id) {
        Payment p = findById(id);
        p.setStatus(PaymentStatus.REJECTED);
        return repo.save(p);
    }

    @Override
    public Payment findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found: " + id));
    }

    @Transactional
    public void cancelBySaleId(Long saleId) {
        repo.findBySaleId(saleId).ifPresent(payment -> {
            payment.setStatus(PaymentStatus.REJECTED);
            repo.save(payment);
        });
    }
}

