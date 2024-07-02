package afternoon.lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextInt()); // int 범위의 +- 랜덤 정수
        System.out.println(random.nextDouble()); // 0 ~ 1.0 소수
        System.out.println(random.nextBoolean()); // T, F 가 랜덤

        System.out.println(random.nextInt(10)); // 0 ~ 9 까지의 정수
    }
}
