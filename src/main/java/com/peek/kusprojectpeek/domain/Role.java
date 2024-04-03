package com.peek.kusprojectpeek.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 일반 사용자와 관리자의 권한으로 나눔
// 일반 사용자: USER, 이메일과 권한 확인
// 관리자: ADMIN, 모든 사용자의 정보 확인

@Getter
@AllArgsConstructor
public enum Role {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
    private String value;
}
