package com.peek.kusprojectpeek.service;

import com.peek.kusprojectpeek.dto.UserDto;
import com.peek.kusprojectpeek.dto.UserFormDto;

public interface UserService {
    UserDto createUser(UserFormDto userFormDto); // 유저 회원 가입
}
