package afternoon.exception.basic;

public class ExceptionCatch {
    public static void main(String[] args) {
        try { // 에러가 예상되는 코드가 들어감
            // 예외 상황 발생 시키기 1. 배열 접근
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println(arr[5]); // 배열의 크기보다 큰 값에 접근, 없는 값에 접근
        } catch (Exception e) {
            e.printStackTrace(); // 에러가 시작된 시점부터 보여줌
        }

        System.out.println("나오나요!?"); // 에러 안 날 것 같음

    }
}
