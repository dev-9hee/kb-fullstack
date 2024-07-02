package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Map 컬렉션 : 키와 값으로 구성된 엔트리 객체를 저장, 키는 중복 저장 불가, 값은 중복 저장 가능
// 키로 사용할 객체가 hashCode() 메소드의 리턴값이 같고 equals() 메소드가 true 를 리턴할 경우 동일 키로 보고 중복 저장을 허용하지 않음
public class HashMapExample {
    public static void main(String[] args) {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("신용권", 85); // 각 타입으로 주어진 키와 값을 추가, 저장이 되는 값을 리턴
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95); // 키 값은 중복 불가, 위에 홍길동 키 내용 사라짐
        // int size() : 저장된 키의 총 수를 리턴
        System.out.println("총 Entry 수 : " + map.size()); // 3
        System.out.println();

        // 키로 값 얻기
        String key = "홍길동";
        int value = map.get(key); // 주어진 키의 값을 리턴
        System.out.println(key + " : " + value);
        System.out.println();

        // 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet(); // Set<String> keySet() : 모든 키를 Set 객체에 담아서 리턴
        Iterator<String> keyIterator = keySet.iterator(); // 객체를 하나씩 가져와라
        while (keyIterator.hasNext()) { // hasNext() : 가져올 객체가 있으면 true return, 없으면 false return
            String k = keyIterator.next(); // next() : 리턴타입 <String>, 컬렉션에서 하나의 객체를 가져옴
            Integer v = map.get(k); // // 주어진 키의 값을 리턴
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<Entry<String, Integer>> entrySet = map.entrySet(); // 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set 에 담아서 리턴
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator(); // 객체를 하나씩 가져와라
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("홍길동");

        System.out.println("총 Entry 수 : " + map.size()); // 2
        System.out.println();
    }
}
