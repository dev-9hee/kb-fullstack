package ch11.sec03.exam02;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        // 처리 해야 할 예외 클래스들이 상속 관계에 있을 때
        // 하위 클래스 catch 블록을 먼저 작성하고 상위 클래스 catch 블록을 나중에 작성
        for(int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(Exception e) {
                System.out.println("실행에 문제가 있습니다.");
            }
        }
    }
}
