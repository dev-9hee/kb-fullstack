package codingtest.week3.study;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test1 {
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        int result1 = factorial(4);
        System.out.println("4! = " + result1);

        int result2 = fibonacci(5);
        System.out.println("result2 = " + result2);
    }
    // base case : 더 이상 자기 자신을 재참조하지 않는 상황을 의미
    // 팩토리얼, O : n
    public static int factorial(int n) {
        if (n == 1) return 1; // base case
        return n * factorial(n - 1); // 재귀호출
    }
    // 피보나치, O : 2^n
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1; // base case
        return fibonacci(n - 1) + fibonacci(n - 2); // 재귀 호출
    }
}
