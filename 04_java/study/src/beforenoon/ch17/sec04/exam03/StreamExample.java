package beforenoon.ch17.sec04.exam03;

import java.util.stream.IntStream;

// 숫자 범위로부터 스트림 얻기
// IntStream 또는 LongStream 의 정적 메소드인 range() 와 rangeClosed() 메소드로 특정 범위의 정수 스트림을 얻을 수 있음
public class StreamExample {
    public static int sum;

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1, 100); // 숫자 범위로부터 스트림 얻기
        stream.forEach(a -> sum += a);
        System.out.println("총합: " + sum);
    }
}
