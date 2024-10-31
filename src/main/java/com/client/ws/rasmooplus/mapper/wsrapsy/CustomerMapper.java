package com.client.ws.rasmooplus.mapper.wsrapsy;

import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.dto.wsraspay.CustomerDto;

public class CustomerMapper {

    public static CustomerDto build(User user) {
        var fullName = user.getName().split(" ");
        var firstName = fullName[0];
        var lastName = fullName.length > 1 ? fullName[fullName.length - 1] : "";

        return CustomerDto.builder()
                .email(user.getEmail())
                .cpf(user.getCpf())
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
