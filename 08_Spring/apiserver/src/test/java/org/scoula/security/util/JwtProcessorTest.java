package org.scoula.security.util;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() { // 토큰이 발급된게 5분전이면 테스트 성공
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDgwNjM3NCwiZXhwIjoxNzI0ODA2Njc0fQ.ecnr4eG4kzo8d5118w8OS91LF_N2XdbAyFlWWcWnkGSDI4Pmd9xf8d78RtfHCpkQ";

        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username); // username 이 null 이 아닌 경우에 테스트가 통과
    }

    @Test
    void validateToken() { // 5분 경과 후 테스트
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDgwNjM3NCwiZXhwIjoxNzI0ODA2Njc0fQ.ecnr4eG4kzo8d5118w8OS91LF_N2XdbAyFlWWcWnkGSDI4Pmd9xf8d78RtfHCpkQ";

        boolean isValid = jwtProcessor.validateToken(token); // 5분 경과 후면 예외 발생
        log.info(isValid);
        assertTrue(isValid); // 5분전이면 true, isValid 가 true 인 경우에 테스트가 통과
    }
}