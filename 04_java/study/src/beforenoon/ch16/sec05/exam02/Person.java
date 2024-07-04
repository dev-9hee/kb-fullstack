package beforenoon.ch16.sec05.exam02;

public class Person {
    // Comparable 인터페이스의 구현체를 매개변수로 받음
    public void ordering(Comparable comparable) {
        String a = "홍길동";
        String b = "김길동";

        // 데이터를 제공하고 추상 메소드를 호출
        int result = comparable.compare(a, b); // comparable.compare(a, b) 메서드를 호출하여 두 문자열을 비교

        if(result < 0) {
            System.out.println(a + "은 " + b + "보다 앞에 옵니다.");
        } else if(result == 0) {
            System.out.println(a + "은 " + b + "과 같습니다.");
        } else {
            System.out.println(a + "은 " + b + "보다 뒤에 옵니다.");
        }
    }
}
