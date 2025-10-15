package com.vehicle.service_api.domain.model;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
}
