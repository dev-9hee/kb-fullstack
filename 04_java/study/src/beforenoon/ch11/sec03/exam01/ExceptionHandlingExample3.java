package beforenoon.ch11.sec03.exam01;

// 문제3) 다음 프로그램에 다중 예외 처리 코드를 추가하세요.
public class ExceptionHandlingExample3 {

    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        // catch 블록이 여러 개라고 해당 타입의 예외 처리 catch 블록만 실행됨
        for(int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }
        }
    }
}
