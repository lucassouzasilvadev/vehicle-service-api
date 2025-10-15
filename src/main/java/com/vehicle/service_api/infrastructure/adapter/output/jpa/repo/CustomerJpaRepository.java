package com.vehicle.service_api.infrastructure.adapter.output.jpa.repo;


import com.vehicle.service_api.infrastructure.adapter.output.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

}

