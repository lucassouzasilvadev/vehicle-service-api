package com.vehicle.service_api.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.VehicleStatus;
import com.vehicle.service_api.infrastructure.adapter.output.output.jpa.VehicleEntity;
import com.vehicle.service_api.infrastructure.adapter.output.output.jpa.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VehicleControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private VehicleRepository repository;

    @Test
    void shouldCreateVehicleThroughRestApi() throws Exception {
        Vehicle vehicle = Vehicle.builder()
                .brand("Nissan")
                .model("Kicks")
                .year(2023)
                .color("Cinza")
                .price(new BigDecimal("125000"))
                .vehicleStatus(VehicleStatus.AVAILABLE)
                .build();

        mockMvc.perform(post("/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(vehicle)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.brand").value("Nissan"))
                .andExpect(jsonPath("$.vehicleStatus").value("AVAILABLE"));
    }

    @Test
    void shouldUpdateVehicleStatusThroughApi() throws Exception {
        // Cria um veículo primeiro
        VehicleEntity vehicle = VehicleEntity.builder()
                .brand("Chevrolet")
                .model("Onix")
                .manufactureYear(2022)
                .color("Azul")
                .price(new BigDecimal("89000"))
                .vehicleStatus(VehicleStatus.AVAILABLE)
                .build();

        VehicleEntity vehicleSaved = repository.save(vehicle);


        // Atualiza o status
        mockMvc.perform(patch("/vehicles/" + vehicleSaved.getId())
                        .param("newStatus", "RESERVED"))
                .andExpect(status().isOk());
    }

}
