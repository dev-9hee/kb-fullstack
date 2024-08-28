package org.scoula.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

// 로그인 결과를 필터에서 직접 Json 응답하기 위한 유틸리티 클래스
// 웹 애플리케이션에서 로그인 결과나 다른 데이터를 클라이언트에게 JSON 형식으로 반환하는 데 유용
public class JsonResponse {
    // 제네릭 타입을 사용하여 다양한 타입의 객체를 JSON 으로 변환 가능, result : JSON 으로 변환할 결과 객체
    public static <T> void send(HttpServletResponse response, T result) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=UTF-8"); // 응답 데이터가 JSON 형식
        Writer out = response.getWriter();
        // result 객체를 JSON 문자열로 변환하여 변환된 JSON 문자열을 응답의 본문에 작성
        out.write(mapper.writeValueAsString(result));
        out.flush(); // Writer 에 작성된 내용을 클라이언트에게 실제로 전송, 강제 전송
    }

    // 응답 코드와 에러 메시지 출력 / 응답, 응답 상태, 오류 메시지
    public static void sendError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        // HttpStatus 객체의 value() 메서드를 호출하여 상태 코드 값을 가져오고, 이를 HTTP 응답의 상태 코드로 설정
        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");
        Writer out = response.getWriter();
        out.write(message);
        out.flush();
    }
}
