package afternoon.collection.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // 데이터 추가
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // LinkedList 가 제일 유리한 케이스
        list.addFirst(0);

        // 둘이 동일한 케이스
        list.addLast(6);

        // 특정 인덱스에 데이터 추가
        list.add(3, 22); // 3번째 인덱스에 데이터 22를 추가해줘

        System.out.println("list = " + list);

        // 검색, 첫번째랑 마지막은 어디 있는지 알고 있음, 시간 얼마 안 걸림
        int firstElement = list.getFirst();
        int lastElement = list.getLast();
        int midElement = list.get(4); // 인덱스4의 데이터, 시간 오래 걸림

        System.out.println("firstElement = " + firstElement);
        System.out.println("lastElement = " + lastElement);
        System.out.println("midElement = " + midElement);

        // 데이터 삭제
        list.removeFirst();
        list.removeLast();
        list.remove(2); // 인덱스 2의 데이터 삭제

    }
}
