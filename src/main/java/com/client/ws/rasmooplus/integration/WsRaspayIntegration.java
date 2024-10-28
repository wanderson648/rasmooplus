package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.PaymentDto;

public interface WsRaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);
    OrderDto createOrder(OrderDto dto);
    Boolean processPayment(PaymentDto dto);

}
