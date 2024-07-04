package afternoon.exception.check;

public class MyCheckException extends Exception{
    public MyCheckException(String message) { // 예외가 어디서 발생할지 모르기 때문에 public 으로 선언
        super(message); // Exception 의 상위인 Throwable 클래스에 메시지 저장
    }

}
