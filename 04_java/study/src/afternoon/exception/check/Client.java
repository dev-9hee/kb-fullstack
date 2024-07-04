package afternoon.exception.check;

import java.util.Random;

// ctrl + alt + L : 줄 맞춤
// alt + enter : 문제 해결 방법 뜸
// 예외를 던져주는 Client 클래스
public class Client {
    public void callException() throws MyCheckException { // 예외를 발생시키는 메서드
        throw new MyCheckException("Client.call 에서 에러 발생");
    }

    public void callRandException() throws MyCheckException2 {
        Random random = new Random();
        boolean now = random.nextBoolean();
        if (now) {
            throw new MyCheckException2("오늘은 운이 없으시군요!");
        } else {
            System.out.println("오늘은 운이 좋으시군요!");
        }
    }
}
