package ch12.sec06;

// 포장 값 비교 : 포장 객체는 번지를 비교 ==, != => 번지 비교
// 포장 클래스의 equals() : 내부 값 비교
public class BoxingUnBoxingExample2 {
    public static void main(String[] args) {
        // -128 ~ 127 초과값일 경우
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==: " + (obj1 == obj2)); // 참조 비교
        System.out.println("equals(): " + obj1.equals(obj2)); // 내용 비교
        System.out.println();

        // -128 ~ 127 범위값일 경우
        Integer obj3 = 300;
        Integer obj4 = 300;
        System.out.println("==: " + (obj3 == obj4));
        System.out.println("equals(): " + obj3.equals(obj4));
    }
}
