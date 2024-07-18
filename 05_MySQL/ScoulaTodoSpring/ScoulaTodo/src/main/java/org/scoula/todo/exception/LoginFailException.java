package org.scoula.todo.exception;

public class LoginFailException extends Exception{
    public LoginFailException(){
        super("사용자 ID 또는 비밀번호가 일치하지 않습니다.");
    }
}
