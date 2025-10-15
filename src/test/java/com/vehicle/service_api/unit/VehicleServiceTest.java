package com.vehicle.service_api.unit;

import com.vehicle.service_api.application.service.VehicleService;
import com.vehicle.service_api.domain.exception.BusinessException;
import com.vehicle.service_api.domain.model.Vehicle;
import com.vehicle.service_api.domain.model.VehicleStatus;
import com.vehicle.service_api.infrastructure.adapter.output.output.jpa.VehicleJpaAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleJpaAdapter vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    private Vehicle vehicleEntity;

    @BeforeEach
    void setup() {
         vehicleEntity = Vehicle.builder()
                .brand("Toyota")
                .model("Corolla")
                .year(2021)
                .color("Preto")
                .price(new BigDecimal("98000.00"))
                .vehicleStatus(VehicleStatus.AVAILABLE)
                .build();
    }

    @Test
    void shouldUpdateStatusForReserved() {
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicleEntity));
        when(vehicleRepository.save(vehicleEntity)).thenReturn(vehicleEntity);
        var vehicleUpdated = vehicleService.updateVehicleStatus(1L, String.valueOf(VehicleStatus.RESERVED));
        verify(vehicleRepository).save(vehicleEntity);
        assertNotNull(vehicleUpdated);
        assertEquals(VehicleStatus.RESERVED, vehicleUpdated.getVehicleStatus());
    }

    @Test
    void deveLancarExceptionSeOVeiculoNaoExiste() {
        when(vehicleRepository.findById(2L)).thenReturn(Optional.empty());
        var exception = assertThrows(BusinessException.class, ()-> {
            vehicleService.updateVehicleStatus(2L, String.valueOf(VehicleStatus.RESERVED));
        });
        assertNotNull(exception);
        assertEquals("Vehicle not found", exception.getMessage());
    }

}
