package com.vehicle.service_api.infrastructure.adapter.output.jpa.mapper;


import com.vehicle.service_api.domain.model.Customer;
import com.vehicle.service_api.infrastructure.adapter.output.entities.CustomerEntity;

public class CustomerMapper {
    public static CustomerEntity toEntity(Customer c) {
        if (c == null) return null;
        return CustomerEntity.builder()
                .id(c.getId())
                .name(c.getName())
                .cpf(c.getCpf())
                .email(c.getEmail())
                .phone(c.getPhone())
                .build();
    }

    public static Customer toDomain(CustomerEntity e) {
        if (e == null) return null;
        return Customer.builder()
                .id(e.getId())
                .name(e.getName())
                .cpf(e.getCpf())
                .email(e.getEmail())
                .phone(e.getPhone())
                .build();
    }
}
