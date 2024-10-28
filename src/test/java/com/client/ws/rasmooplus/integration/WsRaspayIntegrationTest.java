package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WsRaspayIntegrationTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;
    @Test
    void createCustomerWhenDtoOK() {
        CustomerDto dto = new CustomerDto(null, "35553717035", "test@gmail.com",
                "Wanderson", "Oliveira");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDtoOK() {
        OrderDto dto = new OrderDto(null, "671f9f7da44b4f1f8ce27ece", BigDecimal.ZERO, "MONTH22");
        wsRaspayIntegration.createOrder(dto);
    }
}
