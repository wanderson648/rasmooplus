package com.client.ws.rasmooplus.integration.impl;

import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.PaymentDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.query.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
        headers = getHeaders();
    }
    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("https://raspay-api-61f5fa5fc34c.herokuapp.com/ws-raspay/v1/customer",
                            HttpMethod.POST, request, CustomerDto.class);

            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange("https://raspay-api-61f5fa5fc34c.herokuapp.com/ws-raspay/v1/order",
                            HttpMethod.POST, request, OrderDto.class);

            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try {
            HttpEntity<PaymentDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange("https://raspay-api-61f5fa5fc34c.herokuapp.com/ws-raspay/v1/payment/credit-card/",
                            HttpMethod.POST, request, Boolean.class);

            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String(Base64Coder.encode(credential.getBytes()));
        headers.add("Authorization", "Basic "+base64);
        return headers;
    }
}
