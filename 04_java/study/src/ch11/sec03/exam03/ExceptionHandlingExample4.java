package ch11.sec03.exam03;

// 문제4) 다음 프로그램에 다중 예외 처리 코드를 추가하세요.
// 처리할 예외 : ArrayIndexOutOfBoundsException, NullPointerException, NumberFormatException
// NullPointerException, NumberFormatException => 동일한 예외처리
public class ExceptionHandlingExample4 {

    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for(int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (NullPointerException | NumberFormatException e) { // 2가지 예외를 동일하게 처리, 다중 예외처리
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }
}
