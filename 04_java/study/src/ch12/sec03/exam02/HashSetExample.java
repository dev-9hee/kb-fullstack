package ch12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Java 의 HashSet 클래스를 사용하여 새로운 HashSet 객체를 생성하는 것
        // HashSet 은 Java 컬렉션 프레임워크에서 제공되는 Set 인터페이스의 구현체 중 하나입니다
        // Set 은 중복된 요소를 허용하지 않는 데이터 구조
        HashSet hashSet = new HashSet();

        Student s1 = new Student(1, "홍길동");
        hashSet.add(s1);
        System.out.println("저장된 객체 수: " + hashSet.size()); // 1

        // 동등 객체는 중복 저장되지 않음
        Student s2 = new Student(1, "홍길동");
        hashSet.add(s2);
        System.out.println("저장된 객체 수: " + hashSet.size()); // 1

        Student s3 = new Student(2, "홍길동");
        hashSet.add(s3);
        System.out.println("저장된 객체 수: " + hashSet.size()); // 2
    }
}
