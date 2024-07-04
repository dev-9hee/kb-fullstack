package afternoon.exception.real;

import afternoon.exception.real.exceptions.MyCheckException;
import afternoon.exception.real.exceptions.MyUnCheckException;

public class Service {
    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.callException();
            client.callException2();
        } catch (Exception e) {
            // 모든 예외 처리를 하는 메서드를 사용
            exceptionHandler(e);
        }

        System.out.println("막았는가!?");
    }

    public static void exceptionHandler(Exception e) {
        System.out.println("시스템 : 죄송합니다. 알 수 없는 문제가 발생 했습니다!");
        System.out.println("=== 개발자만 보세요 ===");
        e.printStackTrace();

        // 에러 타입에 따라 다르게 처리
        if (e instanceof MyCheckException) {
            System.out.println("MyCheckException 에서 발생한 에러 입니다!");
            // MyCheckException 에만 있는 메서드 활용을 위한 다운 캐스팅
            MyCheckException myCheckException = (MyCheckException) e;
            myCheckException.getMessage();
        } else if (e instanceof MyUnCheckException) {
            System.out.println("MyUnCheckException 에서 발생한 에러 입니다!");
            // MyUnCheckException 에만 있는 메서드 활용을 위한 다운 캐스팅
            MyUnCheckException myUnCheckException = (MyUnCheckException) e;
            myUnCheckException.getMessage();
        }
    }
}
