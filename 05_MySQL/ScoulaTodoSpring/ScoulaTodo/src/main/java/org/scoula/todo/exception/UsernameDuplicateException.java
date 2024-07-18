package org.scoula.todo.exception;

// 사용자 ID 중복
public class UsernameDuplicateException extends Exception{
    public UsernameDuplicateException(){
        super("이미 사용중인 사용자 ID 입니다.");
    }
}
