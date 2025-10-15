package com.vehicle.service_api.domain.ports.input;



import com.vehicle.service_api.domain.model.Sale;
import com.vehicle.service_api.domain.model.enums.SaleStatus;

import java.util.List;

public interface SaleUseCase {
    Sale create(Sale s);
    Sale findById(Long id);
    List<Sale> findAll();
    Sale updateStatus(Long id, SaleStatus status);
    Sale cancelSale(Long id);
}
