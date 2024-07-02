package org.scoula.lib.cli.exception;

// 사용자 정의 예외 클래스 BadMenuException  운영
// Exception : 예외처리 강제 / RuntimeException : 옵션
public class BadMenuException extends Exception {
    public BadMenuException() {
        super("잘못된 메뉴 선택입니다.");
    }

    public BadMenuException(String message) {
        super(message);
    }
}
