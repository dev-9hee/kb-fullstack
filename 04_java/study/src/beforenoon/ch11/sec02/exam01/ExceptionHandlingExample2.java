package beforenoon.ch11.sec02.exam01;

// 문제2) 앞의 프로그램에 예외 처리 코드를 추가하세요.
// 예외 처리 코드 추가
public class ExceptionHandlingExample2 {

    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자수: " + result);
        } catch (NullPointerException e) { // 예외타입, 예외처리
            System.out.println(e.getMessage()); // 예외객체의 메서드로 출력
//            System.out.println(e.toString());
            e.printStackTrace(); // 스택 추적 내용 출력, 개발자 입장에서는 이걸 보는게 좋음
        } finally { // 항상 실행
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); // 매개값으로 null 대입
        System.out.println("[프로그램 종료]");
    }
}
