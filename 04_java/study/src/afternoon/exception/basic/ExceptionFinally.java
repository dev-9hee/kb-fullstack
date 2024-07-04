package afternoon.exception.basic;

public class ExceptionFinally {
    public static void main(String[] args) {
        try { // 에러가 예상되는 코드가 들어감
            Object obj = null;
            obj.equals(null);
        } catch (Exception e) {
            e.printStackTrace(); // 에러가 시작된 시점부터 보여줌
        } finally {
            System.out.println("정말 실행하고 싶은 코드");
        }

        System.out.println("나오나요!?"); // 에러 안 날 것 같음

    }
}
