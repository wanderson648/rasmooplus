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
class WsRaspayIntegrationTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;
    @Test
    void createCustomerWhenDtoOK() {
        CustomerDto dto = new CustomerDto(null, "17215851095", "test@gmail.com",
                "Wanderson", "Oliveira");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDtoOK() {
        OrderDto dto = new OrderDto(null, "671f9f7da44b4f1f8ce27ece", BigDecimal.ZERO, "MONTH22");
        wsRaspayIntegration.createOrder(dto);
    }

    @Test
    void processPaymentWhenDtoOK() {
        CreditCardDto creditCardDto = new CreditCardDto(123L, "17215851095",0L,
                06L, "1234123412341234", 2025L);
        PaymentDto paymentDto = new PaymentDto(creditCardDto, "671f9f7da44b4f1f8ce27ece", "672119da42ac265e8024f4a9");
        wsRaspayIntegration.processPayment(paymentDto);
    }

}
