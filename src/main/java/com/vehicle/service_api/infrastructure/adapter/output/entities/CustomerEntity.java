package com.vehicle.service_api.infrastructure.adapter.output.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    private String email;

    private String phone;
}
