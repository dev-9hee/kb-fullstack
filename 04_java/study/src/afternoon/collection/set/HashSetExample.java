package afternoon.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 선언
        Set<Integer> set = new HashSet<>();

        // 대이터 추가
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        // 중복된 데이터 추가 시도
        boolean isAdded = set.add(30);
        System.out.println("30 추가 시도 결과 = " + isAdded);

        System.out.println("set : " + set);

        // 데이터 검색
        boolean contains20 = set.contains(20);
        boolean contains60 = set.contains(60);

        System.out.println("20이 set 에 존재하는가 = " + contains20);
        System.out.println("60이 set 에 존재하는가 = " + contains60);

        // 데이터 삭제
        boolean isRemoved = set.remove(20);
        boolean isRemoved2 = set.remove(60);

        System.out.println("20 삭제 시도 결과 = " + isRemoved);
        System.out.println("60 삭제 시도 결과 = " + isRemoved2);
        System.out.println("삭제 후 set = " + set);

    }
}
