package afternoon.collection.map;


import java.util.HashMap;
import java.util.Random;

public class ExMainMap {
    public static void main(String[] args) {
        // 1. 길이가 10인 배열 생성
        int[] arr = new int[10];

        // 2. 배열은 값으로 1~10 사이의 랜덤한 정수를 가짐
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1; // 1~10
        }

        // 3. Map 을 이용해서 특정 값이 몇번 나왔는지를 기록하는 Map 데이터 생성
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= arr.length; i++) { // 1-0 2-0 ...
            hashMap.put(i, 0);
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            hashMap.put(num,hashMap.get(num)+1);
        }

        System.out.println("hashMap = " + hashMap);
    }
}
