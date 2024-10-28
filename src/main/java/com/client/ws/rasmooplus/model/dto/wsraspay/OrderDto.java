package com.client.ws.rasmooplus.model.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;

    private String customerId;

    private Long discount;

    private String productAcronym;

}
