package beforenoon.ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

// Optional
// isPresent() 메소드가 true 를 리턴할 때만 집계값 얻기
public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        /* 예외 발생(java.util.NoSuchElementException)
        double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .getAsDouble();
        */

        // 방법 1
        OptionalDouble optional = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
        if(optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: 0.0");
        }

        // 방법 2
        double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .orElse(0.0); // 집계값이 없을 경우 대비해서 디폴트 값 정해놓음
        System.out.println("방법2_평균: " + avg);

        // 방법 3
        list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                // ifPresent() 메소드로 집계값이 있을 경우에만 동작하는 Consumer 람다식 제공
                .ifPresent(a -> System.out.println("방법3_평균: " + a));
    }
}
