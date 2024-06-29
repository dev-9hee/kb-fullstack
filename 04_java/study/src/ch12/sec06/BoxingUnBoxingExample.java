package ch12.sec06;

// 박싱 : 기본 타입 값을 포장 객체로 만드는 과정, 포장 클래스 변수에 기본 타입 값이 대입 시 발생
// 언박싱 : 포장 객체에서 기본 타입 값을 얻어내는 과정, 기본 타입 변수에 포장 객체가 대입 시 발생
public class BoxingUnBoxingExample {
    public static void main(String[] args) {
        // Boxing
        Integer obj = 100; // 박싱
        System.out.println("value: " + obj.intValue());

        // Unboxing
        int value = obj; // 언박싱
        System.out.println("value: " + value);

        // 연산 시 Unboxing
        int result = obj + 100; // 언박싱 후 연산
        System.out.println("result: " + result);
    }
}
