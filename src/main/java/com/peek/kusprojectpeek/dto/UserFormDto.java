package com.peek.kusprojectpeek.dto;

// 회원가입 폼에서 사용자의 이름, 이메일 정보, 패스워드를 입력받는 데 사용되는 dto

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFormDto {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String username;
    private String password;
}
