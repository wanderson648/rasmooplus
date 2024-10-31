package com.client.ws.rasmooplus.mapper.wsrapsy;

import com.client.ws.rasmooplus.model.dto.PaymentProcessDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;

public class OrderMapper {
    public static OrderDto build(String customerId, PaymentProcessDto paymentProcessDto) {
        return OrderDto.builder()
                .customerId(customerId)
                .productAcronym(paymentProcessDto.getProductKey())
                .discount(paymentProcessDto.getDiscount())
                .build();
    }
}
