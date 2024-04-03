package com.peek.kusprojectpeek.service.Impl;

import com.peek.kusprojectpeek.domain.Role;
import com.peek.kusprojectpeek.dto.UserDto;
import com.peek.kusprojectpeek.dto.UserFormDto;
import com.peek.kusprojectpeek.entity.User;
import com.peek.kusprojectpeek.repository.UserRepository;
import com.peek.kusprojectpeek.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserFormDto userFormDto) {

        // 이메일 중복 확인
        if (userRepository.findByEmail(userFormDto.getEmail()) != null) {
            return null;
        }

        // 가입 성공한 모든 유저는 "USER" 권한 부여
        User user = userRepository.save(User.builder()
                        .password(bCryptPasswordEncoder.encode(userFormDto.getPassword()))
                        .email(userFormDto.getEmail())
                        .role(Role.USER)
                        .build());

        return UserDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .build();

    }
}
