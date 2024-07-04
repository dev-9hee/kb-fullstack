package beforenoon.ch15.sec03.exam02;

import java.util.*;

// 동등 객체를 중복 저장하지 않음
// 다른 객체라도 hashCode() 메소드의 리턴 값이 같고, equals() 메소드가 true 를 리턴하면 동일한 객체라고 판단하고 중복 저장 안 함
public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 컬렉션 저장
        Set<Member> set = new HashSet<Member>(); // Member 타입의 객체만 저장

        // Member 객체 저장
        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        // 저장된 객체 수 출력
        System.out.println("총 객체 수 : " + set.size()); // 1
    }
}
