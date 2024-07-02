package ch15.sec05.exam02;

import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

// TreeMap 은 Map 인터페이스의 구현체로서, 키를 자동으로 정렬된 순서로 저장
public class TreeMapExample {
    public static void main(String[] args) {
        // TreeMap 컬렉션 생성, TreeMap(key, value)
        TreeMap<String, Integer> treeMap = new TreeMap<>(); // key 는 String 타입, value 는 Integer 타입으로 리턴

        // 엔트리 저장
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        // 정렬된 엔트리를 하나씩 가져오기
        // Java 에서 TreeMap 의 모든 키-값 쌍을 Set 형태로 반환하는 코드
        Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();

        // 특정 키에 대한 값 가져오기
        // Java 에서 Map.Entry<String, Integer> 타입의 변수를 선언하고 초기값으로 null 을 설정하는 코드
        Entry<String, Integer> entry = null;
        entry = treeMap.firstEntry();
        System.out.println("제일 앞 단어: " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lastEntry();
        System.out.println("제일 뒤 단어: " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lowerEntry("ever");
        System.out.println("ever 앞 단어: " + entry.getKey() + "-" + entry.getValue());

        // 내림차순으로 정렬하기
        NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
        Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        for(Entry<String, Integer> e : descendingEntrySet) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
        System.out.println();

        // 범위 검색
        System.out.println("[c~h 사이의 단어 검색]");
        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", false);
        for(Entry<String, Integer> e : rangeMap.entrySet()) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }
}
