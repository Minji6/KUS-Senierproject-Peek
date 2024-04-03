package com.peek.kusprojectpeek.dto;

//// UserFormDto 에서 입력받은 정보를 UserDto로 변환하고, UserEntity로 생성하기 위해 사용되는 dto.

import com.peek.kusprojectpeek.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;

    @Builder
    public UserDto(Long id, String username, String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
