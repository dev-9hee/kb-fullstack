package beforenoon.ch11.sec02.exam02;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        try {
            // Class.forName() 메서드는 문자열 형태의 클래스 이름을 전달받아 해당 클래스를 로드
            Class.forName("java.lang.String"); // 예외처리 꼭 해줘야 함
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
