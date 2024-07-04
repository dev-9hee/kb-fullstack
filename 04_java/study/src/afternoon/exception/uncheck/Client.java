package afternoon.exception.uncheck;

// ctrl + alt + L : 줄 맞춤
// alt + enter : 문제 해결 방법 뜸
// 예외를 던져주는 Client 클래스
public class Client {
    public void callException() { // 런타임 에러는 명시적 처리인 throws 를 안 해줘도 됨
        throw new MyUnCheckException("Client.call 에서 언체크 에러 발생");
    }

    public void callException2() throws MyCheckException{ // 런타임 에러는 명시적 처리인 throws 를 안 해줘도 됨
        throw new MyCheckException("Client.call 에서 체크 에러 발생");
    }

}
