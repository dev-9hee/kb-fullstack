package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    // JWT 의 유효 시간 설정, 5분 동안 유효한 토큰을 나타내기 위해 설정
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 5; // 1초 * 1분 * 5분 = 5분, 테스트용 5분 – 만기 확인용

    // Secret Key 준비
    private String secretKey = "rlaalstnwjdwlgmlrlaalstnwjdwlgmlrlaalstnwjdwlgml"; // 충분히 긴 암호화에 사용할 임의의 비밀키 문자열 배정
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)); // Key 객체는 나중에 JWT 토큰을 서명하거나 검증하는 데 사용

//    private Key key = Keys.hmacShaKeyFor(SignatureAlgorithm.HS256); // 운영시 사용, 자동 생성

    // JWT (JSON Web Token) 생성
    public String generateToken(String subject) { // 주어진 subject(주로 사용자 이름)를 기반으로 JWT 를 생성
        return Jwts.builder() // JWT 를 만들기 위한 빌더 객체를 생성
                .setSubject(subject) // 토큰의 subject 를 설정, subject 는 JWT 의 "sub" 클레임으로 저장, 일반적으로 사용자 식별자
                .setIssuedAt(new Date()) // 현재 시간을 JWT 의 발행 시간("iat" 클레임)으로 설정
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND)) // 현재 시간으로부터 TOKEN_VALID_MILISECOND(5분) 이후를 만료 시간("exp" 클레임)으로 설정
                .signWith(key) // HMAC-SHA 알고리즘을 사용해 key 로 JWT 를 서명
                .compact(); // 모든 설정을 바탕으로 JWT 를 직렬화하여 String 형태로 반환
    }

    // JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생, 사용자 이름 추출
    // 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException
    public String getUsername(String token) { // 주어진 token 에서 subject(사용자 이름)를 추출
        return Jwts.parserBuilder() // JWT 를 파싱(구조화된 데이터로 변환) 하기 위한 파서 빌더 객체를 생성
                .setSigningKey(key) // JWT 를 검증하기 위해 서명에 사용된 키를 설정
                .build() // 파서를 빌드
                .parseClaimsJws(token) // JWT 를 파싱하고 서명을 검증, 유효한 JWT 라면 클레임(Claims)을 반환
                .getBody() // JWT 의 클레임 부분을 가져옴
                .getSubject(); // 클레임에서 subject(사용자 이름)를 추출하여 반환
    }

    // JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생
    public boolean validateToken(String token) { // 주어진 token 의 유효성을 검증
        Jws<Claims> claims = Jwts.parserBuilder() // JWT 를 파싱하기 위한 파서 빌더 객체를 생성
                .setSigningKey(key) // 서명 검증을 위해 키를 설정
                .build() // 파서를 빌드
                .parseClaimsJws(token); // JWT 를 파싱하고 서명을 검증, 토큰이 유효하다면 Jws<Claims> 객체를 반환
        return true; // 토큰이 유효하면 true 를 반환
    }
}

/* 예외 설명
- ExpiredJwtException: 유효 시간 만기
- UnsupportedJwtException: 지원하지 않은 JWT
- MalformedJwtException: 잘못된 JWT 포맷 예외
- SignatureException: 서명 불일치 예외
- IllegalArgumentException: 잘못된 정보 포함
 */
