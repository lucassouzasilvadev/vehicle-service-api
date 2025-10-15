package com.vehicle.service_api.infrastructure.adapter.output.output.jpa;

import com.vehicle.service_api.domain.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByVehicleStatusOrderByPriceAsc(VehicleStatus status);
}
