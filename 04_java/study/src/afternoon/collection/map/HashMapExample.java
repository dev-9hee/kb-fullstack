package afternoon.collection.map;

import java.util.HashMap;

// 접근 조회가 빠름, 순서보장 안 됨, 속도는 빠름
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(); // Key 는 String 으로 많이 지정

        // 데이터 추가 (put)
        hashMap.put("사과", 10000);
        hashMap.put("바나나", 2000);
        hashMap.put("토마토", 500);
        hashMap.put("수박", 20000);

        // hashMap 출력
        System.out.println("hashMap = " + hashMap);

        // 특정 키의 값 가져오기 (get)
        int applePrice = hashMap.get("사과");
        System.out.println("applePrice = " + applePrice); // 사과 가격

        // 키가 존재하는지 확인 (containsKey)
        boolean hasBanana = hashMap.containsKey("바나나");
        System.out.println("바나나 존재 여부 확인 = " + hasBanana);

        // 값이 존재하는지 확인 (containsValue)
        boolean hasValue20000 = hashMap.containsValue(20000);
        System.out.println("20000원 과일 존재 여부 = " + hasValue20000);

        // 데이터 삭제 (remove)
        int removedValue = hashMap.remove("수박"); // 지워질 때 지워지는 값 리턴됨
        System.out.println("removedValue = " + removedValue);
        System.out.println("hashMap = " + hashMap);

        // 크기 확인 (size)
        int size = hashMap.size();
        System.out.println("size = " + size);
    }
}
