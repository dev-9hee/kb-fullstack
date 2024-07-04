package beforenoon.ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        // 문장 스트림을 단어 스트림으로 변환
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream()
                // 하나의 요소를 복수 개의 요소들로 변환한 새로운 스트림을 리턴
                .flatMap(data -> Arrays.stream(data.split(" ")))
                // forEach() 메서드는 컬렉션 데이터 구조의 각 요소에 대해 지정된 작업을 수행
                .forEach(word -> System.out.println(word)); // 각 요소(word)를 콘솔에 출력

        System.out.println();

        // 문자열 숫자 목록 스트림을 숫자 스트림으로 변환
        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        list2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));
    }
}
