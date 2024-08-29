package org.scoula.security.account.domain;

import org.springframework.security.core.GrantedAuthority;

public class AuthVO implements GrantedAuthority { // 권한 정보 추출
    private String username; // user id
    private String auth; // 권한

    @Override
    public String getAuthority() {
        return auth;
    }
}

// ADMIN : 최고 관리자 => ROLE_ADMIN, ROLE_MANAGER, ROLE_MEMBER
// MANAGER : 일반 관리자 => ROLE_MANAGER, ROLE_MEMBER
// MEMBER : 일반 회원 => ROLE_MEMBER
