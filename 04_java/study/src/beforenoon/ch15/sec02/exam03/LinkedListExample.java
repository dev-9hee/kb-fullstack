package beforenoon.ch15.sec02.exam03;

import java.util.ArrayList; // 더 많이 사용
import java.util.LinkedList; // 중간에 삽입 잘 안 함
import java.util.List;

// LinkedList : 인접 객체를 체인처럼 연결해서 관리
// 객체 삭제와 삽입이 빈번한 곳에서 ArrayList 보다 유리
// But,,, index 검색이 어려움 / get(1000).. 인덱스를 쫒아가야 됨
public class LinkedListExample {
    public static void main(String[] args) {
        // ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<String>(); // String 타입의 객체만 저장

        // LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<String>(); // String 타입의 객체만 저장

        // 시작 시간과 끝 시간을 저장할 변수 선언
        long startTime;
        long endTime;

        // ArrayList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime(); // 현재 시간을 나노초 단위로 측정하여 startTime 변수에 저장, 특정 작업의 수행 시간을 측정 가능
        for (int i = 0; i < 10000; i++) {
            // 첫 번째 인자 0은 새로운 요소를 추가할 인덱스, 두 번째 인자 String.valueOf(i)는 추가할 요소의 값(정수형 변수 i의 값을 문자열로 변환하여 추가)
            // String.valueOf(Object)를 통해 임의의 객체를 문자열로 변환
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime - startTime));

        //LinkedList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ", (endTime - startTime));

    }
}
