package beforenoon.ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// 내부 반복자 : 요소 처리 방법을 컬렉션 내부로 주입시켜서 요소를 반복 처리
public class ParallelStreamExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("람다식");
        list.add("박병렬");

        // 병렬 처리
        // 컬렉션(예: List)의 데이터를 병렬로 처리할 수 있도록 해주는 메서드
        // 병렬로 처리한다는 것은 작업을 여러 개의 스레드(thread)에 분산하여 동시에 실행하는 것을 의미
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach( name -> {
            System.out.println(name + ": " + Thread.currentThread().getName()); // 현재 실행 중인 스레드의 이름을 가져오는 메서드
        });
    }
}
