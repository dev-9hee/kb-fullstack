package beforenoon.ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

// 요소 객체가 Comparable 을 구현하고 있지 않다면, 비교자를 제공하여 요소를 정렬
// sorted((o1, o2) -> {...}) : {}안에는 o1 < o2 음수, o1 == o2 0, o1 > o2 양수 리턴하도록 작성
// o1, o2 가 정수일 경우에는 Integer.compare(o1, o2) / 실수일 경우에는 Double.compare(o1, o2)를 호출해서 리턴값 리턴 가능
public class SortingExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("유미선", 20));

        // 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}
