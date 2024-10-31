package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.exception.BusinessException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.mapper.UserPaymentInfoMapper;
import com.client.ws.rasmooplus.mapper.wsrapsy.CreditCardMapper;
import com.client.ws.rasmooplus.mapper.wsrapsy.CustomerMapper;
import com.client.ws.rasmooplus.mapper.wsrapsy.OrderMapper;
import com.client.ws.rasmooplus.mapper.wsrapsy.PaymentMapper;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserPaymentInfo;
import com.client.ws.rasmooplus.model.dto.PaymentProcessDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.model.dto.wsraspay.PaymentDto;
import com.client.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.service.PaymentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private final UserRepository userRepository;
    private final UserPaymentInfoRepository userPaymentInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;
    @Override
    public Boolean process(PaymentProcessDto dto) {
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());

        if(userOpt.isEmpty()) {
            throw new NotFoundException("Usuário não encontrado");
        }
        User user = userOpt.get();
        if (Objects.nonNull(user.getSubscriptionType())) {
            throw new BusinessException("Pagamento não pode ser processado pois usuário já possui assinatura");
        }

        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(), dto));

        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getId(),
                CreditCardMapper.build(dto.getUserPaymentInfoDto(), user.getCpf()));

        Boolean successPayment = wsRaspayIntegration.processPayment(paymentDto);

        if(successPayment) {
            UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user);
            userPaymentInfoRepository.save(userPaymentInfo);
        }
        return null;
    }
}
