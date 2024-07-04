package beforenoon.ch15.sec03.exam03;

import java.util.*;

// iterator() 메소드 : 반복자를 얻어 Set 컬렉션의 객체를 하나씩 가져옴
public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

        // 객체 추가
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        // 객체를 하나씩 가져와라
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) { // hasNext() : 가져올 객체가 있으면 true return, 없으면 false return
            // 객체를 하나 가져오기
            String element = iterator.next(); // next() : 리턴타입 <String>, 컬렉션에서 하나의 객체를 가져옴
            System.out.println(element); // A, B, C, D
            if (element.equals("C")) {
                // 가져온 객체를 컬렉션에서 제거
                iterator.remove(); // next()로 가져온 객체를 Set 컬렉션에서 제거
            }
        }
        System.out.println();

        // 객체 제거
        set.remove("B");

        // 객체를 하나씩 가져와서 처리
        for(String element : set) {
            System.out.println(element);
        }
    }
}
