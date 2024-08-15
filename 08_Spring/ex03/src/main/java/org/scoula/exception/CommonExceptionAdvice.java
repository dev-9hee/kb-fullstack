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

    // 특정한 예외가 발생했을 때 사용자에게 적절한 오류 메시지를 보여주고 싶을 때 사용
    @ExceptionHandler(Exception.class) // 특정 예외를 처리하기 위한 메서드를 정의하는 데 사용
    public String except(Exception ex, Model model) {

        log.error("Exception ......" + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        return "error_page";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex) {
        return "custom404";
    }
}
