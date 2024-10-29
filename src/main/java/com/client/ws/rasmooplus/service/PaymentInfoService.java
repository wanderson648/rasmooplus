package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.model.dto.PaymentProcessDto;

public interface PaymentInfoService {
    Boolean process(PaymentProcessDto dto);
}
