package com.client.ws.rasmooplus.model.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;

    private String customerId;

    private BigDecimal discount;

    private String productAcronym;

}
