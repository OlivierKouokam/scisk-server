package com.scisk.sciskbackend.service;

import com.scisk.sciskbackend.dto.UserCreateDto;
import com.scisk.sciskbackend.dto.UserReturnDto;

public interface UserService {
    UserReturnDto createAccount(UserCreateDto userCreateDto);
}
