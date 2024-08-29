package org.scoula.security.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

// User 클래스 : 스프링에서 정의된 UserDetails 구현체로 스프링 시큐리티에서 요구하는 최소 정보만 유지
// 애플리케이션에서 필요한 사용자 추가 정보(MemberVO) 관리
@Getter
@Setter
public class CustomUser extends User {
    private MemberVO member; // 실질적인 사용자 데이터

    // 인증 정보만으로 CustomUser 를 생성할 때 사용
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    // MemberVO 객체를 통해 인증 정보와 사용자 데이터를 모두 초기화할 때 사용
    public CustomUser(MemberVO vo) {
        super(vo.getUsername(), vo.getPassword(), vo.getAuthList());
        this.member = vo;
    }
}
