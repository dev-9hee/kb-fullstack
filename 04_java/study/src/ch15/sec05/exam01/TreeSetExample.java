package ch15.sec05.exam01;

import java.util.*;

// TreeSet : 이진 트리를 기반으로 한 Set 컬렉션, 여러 개의 노드가 트리 형태로 연결된 구조
// Set 타입 변수에 대입해도 되지만 TreeSet 타입으로 대입하는 이유는 검색 관련 메소드가 TreeSet 에만 정의되어 있기 때문
public class TreeSetExample {
    public static void main(String[] args) {
        // TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>(); // 리턴 타입 : Integer

        // Integer 객체 생성
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        // 정렬된 Integer 객체를 하나씩 가져오기
        for(Integer s : scores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        // 특정 Integer 객체를 가져오기
        System.out.println("가장 낮은 점수 : " + scores.first()); // 제일 낮은 객체를 리턴, 75
        System.out.println("가장 높은 점수 : " + scores.last()); // 제일 높은 객체를 리턴, 98
        System.out.println("95점 아래 점수 : " + scores.lower(95)); // 주어진 객체보다 바로 아래 객체를 리턴, 87
        System.out.println("95점 위의 점수: " + scores.higher(95)); // 주어진 객체보다 바로 위 객체를 리턴, 98
        // 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 바로 아래 객체 리턴, 95
        System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
        // 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 바로 위 객체 리턴, 87
        System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

        // 내림차순으로 정렬하기
        NavigableSet<Integer> descendingScores = scores.descendingSet(); // 내림차순으로 정렬된 NavigableSet 을 리턴
        for(Integer s : descendingScores) {
            System.out.print(s + " ");
        }
        System.out.println("\n"); // 98 95 87 80 75

        // 범위 검색( 80 <= )
        // tailSet( , ) : 주어진 객체보다 높은 객체들을 NavigableSet 으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for(Integer s : rangeSet) {
            System.out.print(s + " ");
        }
        System.out.println("\n"); // 80 87 95 98

        // 범위 검색( 80 <= score < 90 )
        // subSet( ,,, ) : 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet 으로 리턴
        // 시작과 끝 객체의 포함 여부는 두번째, 네번째 매개값에 따라 달라짐
        rangeSet = scores.subSet(80, true, 90, false);
        for(Integer s : rangeSet) {
            System.out.print(s + " "); // 80 87
        }
    }
}
