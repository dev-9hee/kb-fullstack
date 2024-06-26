package ch11.sec05;

public class ThrowsExample2 {
    // 나열할 예외 클래스가 많으면 throws Exception 또는 throws Throwable 로 모든 예외 떠넘기기
    public static void main(String[] args) throws Exception {
        findClass();
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
