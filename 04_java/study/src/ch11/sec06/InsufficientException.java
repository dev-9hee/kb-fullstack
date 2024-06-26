package ch11.sec06;

// 사용자 정의 예외 : 표준 라이브러리에는 없어 직접 정의하는 예외 클래스
// 일반 예외는 Exception 의 자식 클래스로 선언
// 실행 예외는 RuntimeException 의 자식 클래스로 선언
public class InsufficientException extends Exception {
    // 기본 생성자
    public InsufficientException() {
    }

    // 예외 메시지를 입력받는 생성자
    public InsufficientException(String message) {
        super(message);
    }
}
