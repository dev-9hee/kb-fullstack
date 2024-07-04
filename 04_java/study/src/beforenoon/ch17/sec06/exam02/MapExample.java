package beforenoon.ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

// 매핑, 기본 타입 요소를 래퍼 객체 요소로 변환하는 간편한 메소드 사용
public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream() // int -> double, long -> double
                .forEach(d -> System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed() // int -> Integer, long -> Long, double -> Double
                .forEach(obj -> System.out.println(obj.intValue()));
    }
}
