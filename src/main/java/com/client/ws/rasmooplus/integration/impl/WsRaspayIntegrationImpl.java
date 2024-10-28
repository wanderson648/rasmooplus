package com.client.ws.rasmooplus.integration.impl;

import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.PaymentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;
    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
    }
    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        return null;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        return null;
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        return null;
    }
}
