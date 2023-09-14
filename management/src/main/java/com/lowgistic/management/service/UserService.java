package com.lowgistic.management.service;

import com.lowgistic.management.service.dto.UserDto;

public interface UserService {
    UserDto create(final UserDto userDto)throws Exception;
}
