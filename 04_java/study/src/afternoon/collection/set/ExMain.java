package afternoon.collection.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ExMain {
    public static void main(String[] args) {
        // 1. 길이가 10인 배열 생성
        int[] arr = new int[10];

        // 2. 배열은 값으로 1~10 사이의 랜덤한 정수를 가짐
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1; // 1~10
        }

        // 3. Set 을 이용해서 발생한 배열에 중복 값이 있으면 "중복이다!"
        // 중복이 없을 경우에는 "중복이 아니다!"
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isNotDuplicated = set.add(arr[i]); // 중복이 아니면 추가돼서 true
            if (!isNotDuplicated) {
                System.out.println("중복이다!!");
            } else {
                System.out.println("중복이 아니다!");
            }
        }
    }
}
