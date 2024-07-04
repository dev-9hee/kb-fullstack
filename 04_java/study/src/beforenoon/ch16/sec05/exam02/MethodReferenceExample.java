package beforenoon.ch16.sec05.exam02;

// 메서드 참조(Method Reference)를 사용하여 Comparable 인터페이스의 구현체를 전달
// 매개변수의 메소드 참조
// a 클래스 이름 :: 메소드 이름
public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        // String.compareToIgnoreCase()는 두 문자열을 대소문자를 무시하고 비교하는 메서드
        // 음수: 첫 번째 문자열이 두 번째 문자열보다 사전순으로 앞에 있음
        // 0: 두 문자열이 같음
        // 양수: 첫 번째 문자열이 두 번째 문자열보다 사전순으로 뒤에 있음
        person.ordering(String :: compareToIgnoreCase); // (a, b) -> a.compareToIgnoreCase(b)
    }
}
