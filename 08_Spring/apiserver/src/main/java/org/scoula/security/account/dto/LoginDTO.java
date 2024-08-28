package org.scoula.security.account.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;

// username, password 프로퍼티를 가짐
// json 문자열에서 LoginDTO 객체로 역직렬화 직접 수행
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request) throws AuthenticationException {
        ObjectMapper om = new ObjectMapper(); // JSON 데이터를 Java 객체로 변환하거나, Java 객체를 JSON 데이터로 변환하는 데 사용
        try {
            // ObjectMapper 의 readValue 메서드는 입력 스트림에서 JSON 데이터를 읽어, 지정된 클래스(LoginDTO) 타입의 객체로 변환
            return om.readValue(request.getInputStream(), LoginDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 이 예외는 주로 인증 과정에서 자격 증명이 유효하지 않을 때 사용
            throw new BadCredentialsException("username 또는 password 가 없습니다.");
        }
    }
}
