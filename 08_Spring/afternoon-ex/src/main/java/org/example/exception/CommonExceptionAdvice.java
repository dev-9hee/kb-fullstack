package org.example.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice { // 전역에서 발생하는 예외 처리
    private String context = "/exception";

    @ExceptionHandler(NoHandlerFoundException.class) // 404 에러만 처리
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404임을 표현하기 위한 헤더를 자동으로 설정
    public String handle404(NoHandlerFoundException e) {
        return context + "/404";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        e.printStackTrace();

        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", Arrays.asList(e.getStackTrace())); // asList : 강제로 배열로 만들어 줌

        return context + "/error-page";
    }
}
