package afternoon.exception.uncheck;

public class Service {
    public static void main(String[] args) {
        Client client = new Client();

        // 언체크 예외라 컴파일러는 스킵했지만 개발자를 처리 해줘야 함
        try {
            client.callException(); // 예외처리 안 해줬는데 오류 안 뜸
            client.callException2();
        } catch (MyUnCheckException e) {
            e.printStackTrace();
//            e.printStackTrace(System.out); // 에러문이 회색으로
        } catch (MyCheckException e) {
            e.printStackTrace();
        }

        System.out.println("막았는가!?");
    }
}
