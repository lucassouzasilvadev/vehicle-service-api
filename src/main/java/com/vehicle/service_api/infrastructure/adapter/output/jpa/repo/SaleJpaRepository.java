package com.vehicle.service_api.infrastructure.adapter.output.jpa.repo;


import com.vehicle.service_api.infrastructure.adapter.output.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {}
