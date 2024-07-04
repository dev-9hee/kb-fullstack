package beforenoon.ch11.sec05;

// 문제7) 다음 코드가 예외 처리가 되도록 코드를 완성하세요.
// 예외 떠넘기기
public class ThrowsExample1 {
    public static void main(String[] args) {

        // 메소드 내부에서 예외 발생 시 throws 키워드 이용해 메소드를 호출할 곳으로 예외 떠넘기기
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("예외 처리: " + e.toString());
        }
    }

    // findClass() 메서드는 throws ClassNotFoundException 절을 통해 이 예외를 호출 메서드로 전달
    public static void findClass() throws ClassNotFoundException {
        // Class.forName() 메서드는 주어진 클래스 이름에 해당하는 클래스를 로드하는데,
        // 만약 해당 클래스를 찾지 못하면 ClassNotFoundException 이 발생합니다.
        Class.forName("java.lang.String2");
    }

    // findClass() 메서드에서 발생할 수 있는 ClassNotFoundException 을 throws 키워드를 통해 메서드 호출 부분으로 전달하고 있다는 점!!
}
