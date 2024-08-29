package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.userdetails.User;

import java.util.List;

// 로그인 성공 시 응답에 포함시킬 사용자 정보, token, user(username, email, roles) 포함
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    String username;
    String password;
    List<String> roles; // 역할

    public static UserInfoDTO of(MemberVO member) {
        return new UserInfoDTO(
                member.getUsername(), // 객체에서 사용자 이름 가져옴
                member.getEmail(), // MemberVO 객체에서 이메일 주소 가져옴
                member.getAuthList().stream() // MemberVO 객체의 권한 목록을 반환, 권한 목록을 스트림으로 변환
                        .map(a -> a.getAuthority()) // 각 Authority 객체를 그 권한 문자열로 매핑
                        .toList() // 매핑된 권한 문자열들을 리스트로 수집
        );
    }
}
