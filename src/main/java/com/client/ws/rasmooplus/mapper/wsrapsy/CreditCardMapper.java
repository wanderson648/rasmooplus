package com.client.ws.rasmooplus.mapper.wsrapsy;

import com.client.ws.rasmooplus.model.dto.UserPaymentInfoDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.CreditCardDto;

public class CreditCardMapper {
    public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber) {
        return CreditCardDto.builder()
                .documentNumber(documentNumber)
                .cvv(Long.parseLong(dto.getCardSecurityCode()))
                .number(dto.getCardNumber())
                .month(dto.getCardExpirationMonth())
                .year(dto.getCardExpirationYear())
                .installments(dto.getInstallments())
                .build();
    }
}
