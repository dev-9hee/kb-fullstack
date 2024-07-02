package codingtest.week1.exam02;

import java.util.Arrays;

public class Study1 {
    public static void main(String[] args) {
        int MAX = 100000;

        // 에라토스테네스의 체 사용
        long startTime = System.currentTimeMillis();
        boolean[] arr = new boolean[MAX + 1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false; // 0과 1은 소수가 아님
        sieveOfEratosthenes(arr);

        //에라토스테네스의 체
        int sum = 0;
        for (int i = 2; i <= MAX; i++) {
            if (arr[i])
                sum+=i;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("에라토스테네스의 체 수행 시간: " + elapsedTime + "ms");

        // 단순 소수 판별법 사용
        startTime = System.currentTimeMillis();
        sum = 0;
        for (int i = 2; i <= MAX; i++) {
            if (isPrimeSimple(i))
                sum+=i;
        }

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("단순 소수 판별법 수행 시간: " + elapsedTime + "ms");
    }
    public static void sieveOfEratosthenes(boolean[] arr) {
        int n = arr.length;
        for (int i = 2; i * i < n; i++) {
            if (arr[i]) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    // 단순 소수 판별 메서드
    public static boolean isPrimeSimple(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i < num; i ++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
