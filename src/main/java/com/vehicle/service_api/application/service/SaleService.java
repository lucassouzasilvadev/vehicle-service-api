package com.vehicle.service_api.application.service;


import com.vehicle.service_api.application.saga.SagaEventPublisher;
import com.vehicle.service_api.application.saga.events.SaleCancelledEvent;
import com.vehicle.service_api.application.saga.events.SaleCreatedEvent;
import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.domain.model.enums.SaleStatus;
import com.vehicle.service_api.domain.ports.input.SaleUseCase;
import com.vehicle.service_api.domain.ports.output.SaleRepositoryPort;
import com.vehicle.service_api.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleUseCase {
    private final SaleRepositoryPort repo;
    private final SagaEventPublisher publisher;

    @Override
    public Sale create(Sale s) {
        s.setSaleDate(LocalDateTime.now());
        if (s.getStatus() == null) s.setStatus(SaleStatus.CREATED);
        Sale saved = repo.save(s);
        publisher.publish(new SaleCreatedEvent(saved.getId()));
        return saved;
    }

    @Override
    public Sale cancelSale(Long saleId) {
        Sale sale = repo.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        sale.setStatus(SaleStatus.CANCELLED);
        Sale saleUpdated = repo.save(sale);

        publisher.publish(new SaleCancelledEvent(saleUpdated.getId()));
        return saleUpdated;
    }


    @Override
    public Sale findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sale not found: " + id));
    }

    @Override
    public List<Sale> findAll() { return repo.findAll(); }

    @Override
    public Sale updateStatus(Long id, SaleStatus status) {
        Sale ex = findById(id); ex.setStatus(status); return repo.save(ex);
    }

}
