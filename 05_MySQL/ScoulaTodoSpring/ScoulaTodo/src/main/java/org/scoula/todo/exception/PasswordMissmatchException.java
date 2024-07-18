package org.scoula.todo.exception;

// 비밀번호, 비밀번호2 불일치
public class PasswordMissmatchException extends Exception{
    public PasswordMissmatchException(){
        super("비밀번호가 맞지 않습니다.");
    }
}