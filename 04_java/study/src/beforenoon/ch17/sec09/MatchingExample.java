package beforenoon.ch17.sec09;

import java.util.Arrays;

// 매핑 : 요소들이 특정 조건에 만족하는지 여부를 조사하는 최종 처리 기능 / true, false 리턴
public class MatchingExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0); // 모든 요소가 만족하는지 여부
        System.out.println("모두 2의 배수인가? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a % 3 == 0); // 최소한 하나의 요소가 만족하는지 여부
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a % 3 == 0); // 모든 요소가 만족하지 않는지 여부
        System.out.println("3의 배수가 없는가? " + result);
    }
}
