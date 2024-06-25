package ch05.sec05;

public class EqualsExample {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = "홍길동";

        // 위 코드에서 str1과 str2는 동일한 문자열 리터럴 "홍길동"을 가리키고 있음
        // 이 경우, 자바는 문자열 풀을 사용하여 동일한 리터럴을 재사용하기 때문에,
        // str1과 str2는 동일한 메모리 위치를 참조하게 된다.
        // 참조 비교
        if(str1 == str2) {
            System.out.println("str1과 str2는 참조가 같음");
        } else {
            System.out.println("str1과 str2는 참조가 다름");
        }

        // 문자열 비교
        if(str1.equals(str2)) {
            System.out.println("str1과 str2는 문자열이 같음");
        }

        // new 연산자(객체 생성 연산자)로 직접 String 객체를 생성/대입 가능
        // 참조 다름, str3과 str4는 다른 메모리 위치를 참조하는 별도의 객체
        // new String("홍길동")는 새로운 String 객체를 힙(heap)에 생성하며, 따라서 각 호출은 새로운 객체를 생성
        String str3 = new String("홍길동");
        String str4 = new String("홍길동");

        if(str3 == str4) {
            System.out.println("str3과 str4는 참조가 같음");
        } else {
            System.out.println("str3과 str4는 참조가 다름");
        }

        // 문자열 비교
        if(str3.equals(str4)) {
            System.out.println("str3과 str4는 문자열이 같음");
        }
    }
}
