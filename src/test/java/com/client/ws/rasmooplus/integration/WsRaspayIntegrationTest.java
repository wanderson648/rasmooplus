package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
