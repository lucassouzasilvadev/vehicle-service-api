package com.vehicle.service_api.infrastructure.adapter.output.jpa.repo;



import com.vehicle.service_api.infrastructure.adapter.output.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {

}


