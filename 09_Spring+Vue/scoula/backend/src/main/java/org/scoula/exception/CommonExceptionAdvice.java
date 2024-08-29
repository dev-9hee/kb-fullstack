package org.scoula.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

// 여러 컨트롤러에서 발생하는 예외를 한 곳에서 처리할 수 있게 해줌
@ControllerAdvice // 전역적으로 예외를 처리할 수 있는 클래스에 붙임
@Log4j
public class CommonExceptionAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex) {
        return "/resources/index.html";
    }
}
