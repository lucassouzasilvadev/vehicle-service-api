package com.vehicle.service_api.domain.ports.output;



import com.vehicle.service_api.domain.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepositoryPort {
    Sale save(Sale sale);
    Optional<Sale> findById(Long id);
    List<Sale> findAll();
    void deleteById(Long id);
}
