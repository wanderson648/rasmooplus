package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.dto.UserDto;

public interface UserService {
    User create(UserDto dto);
}