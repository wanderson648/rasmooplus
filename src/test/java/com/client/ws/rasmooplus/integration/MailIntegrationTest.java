package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.model.dto.wsraspay.CreditCardDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.PaymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class MailIntegrationTest {
    @Autowired
    private MailIntegration mailIntegration;
    @Test
    void createCustomerWhenDtoOK() {
        mailIntegration.send("wanderscorpio@gmail.com", "Ola world", "Acesso Liberado");
    }
}
