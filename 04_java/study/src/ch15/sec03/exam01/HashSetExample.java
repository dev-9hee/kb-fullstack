package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

// Set 컬렉션 : 저장 순서가 유지되지 않음, 객체 중복 저장 불가, 하나의 null 만 저장 가능
public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

        // 객체 저장
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A"); // 중복 객체이므로 저장하지 않음
        set.add("E");

        // 저장된 객체 수 출력
        int size = set.size();
        System.out.println("총 객체 수(size) : " + size); // 4
    }
}
