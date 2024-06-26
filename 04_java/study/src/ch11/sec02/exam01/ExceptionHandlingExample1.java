package ch11.sec02.exam01;

// 문제1) 다음 프로그램의 문제점을 설명하고, 그 결과를 확인하세요.
// 문제점 : printLength() 메서드에서 NullPointerException 이 발생할 수 있다.
// 이 경우 프로그램은 비정상적으로 종료되며, 예외 처리가 이루어지지 않는다.
public class ExceptionHandlingExample1 {

    public static void printLength(String data) {
        int result = data.length(); // data 가 null 일 경우 NullPointerException 발생
        System.out.println("문자수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); // 매개값으로 null 대입
        System.out.println("[프로그램 종료]");
    }
}
