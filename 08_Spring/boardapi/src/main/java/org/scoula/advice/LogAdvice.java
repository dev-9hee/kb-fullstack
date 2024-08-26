package org.scoula.advice;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 이 클래스가 AOP 의 "Aspect"로 사용됨을 나타냄
// Aspect 는 프로그램의 여러 부분에 걸쳐 반복되는 기능(예: 로깅, 트랜잭션 관리)을 모듈화한 것
@Aspect
@Log4j
@Component // 빈으로 등록됨
public class LogAdvice {
    // AOP 기능을 활용하여 특정 메소드가 호출되기 전에 로그를 남기는 클래스

    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))") // 포인트컷 표현식
    public void logBefore() {
        log.info("=======================");
    }

    // args 를 이용한 파라미터 추적
    // 예외가 발생했을 때 어떤 파라미터에 문제가 있는지 알고 싶은 경우
    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)") // 포인트컷 표현식
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1: " + str1);
        log.info("str2: " + str2);
    }

    // 지정된 대상이 예외를 발생한 후에 동작
    @AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!");
        log.info("exception: " + exception);
    }

    // 메서드의 실행 전과 실행 후에 처리가 가능
    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));
        Object result = null;
        try {
            result = pjp.proceed(); // 실제 메서드 호출
        } catch(Throwable e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        log.info("TIME: " + (end - start));
        return result;
    }
}
