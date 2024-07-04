package beforenoon.ch17.sec01;

import java.util.*;
import java.util.stream.Stream;

// 스트림 : 요소들이 하나씩 흘러가면서 처리된다는 의미
// 컬렉션 및 배열의 요소를 반복 처리하기 위해 스트립 사용
public class StreamExample {
    public static void main(String[] args) {
        // Set 컬렉션 생성
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("김자바");

        // Stream 을 이용한 요소 반복 처리
        Stream<String> stream = set.stream(); // List 컬렉션의 stream() 메소드로 Stream 객체 얻기
        stream.forEach( name -> System.out.println(name) ); // forEach() : 요소를 어떻게 처리할지 람다식으로 제공
    }
}
