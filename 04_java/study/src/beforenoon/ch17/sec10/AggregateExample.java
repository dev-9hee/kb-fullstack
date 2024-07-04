package beforenoon.ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        // 정수 배열
        int[] arr = {1, 2, 3, 4, 5};

        // 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .count(); // 요소 개수 -> 리턴타입 : long
        System.out.println("2의 배수 개수: " + count);

        // 총합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .sum(); // 요소 총합 -> 리턴타입 : int, long, double
        System.out.println("2의 배수의 합: " + sum);

        // 평균
        double avg = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .average() // 요소 평균 -> 리턴타입 : OptionalDouble
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        // 최대값
        int max = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .max() // 최대 요소 -> 리턴타입 : Optional<T>, OptionalXXX
                .getAsInt();
        System.out.println("최대값: " + max);

        // 최소값
        int min = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .min() // 최소 요소 -> 리턴타입 : Optional<T>, OptionalXXX
                .getAsInt();
        System.out.println("최소값: " + min);

        // 첫 번째 요소
        int first = Arrays.stream(arr)
                .filter(n -> n%3 == 0)
                .findFirst() // 첫 번째 요소 -> 리턴타입 : OptionalXXX
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }
}
