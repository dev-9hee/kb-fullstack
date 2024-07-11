package study.recursion;

import org.w3c.dom.Node;

public class FibonacciRecursive {
    public static void main(String[] args) {
        int number = 10; // 예시로 10번째 피보나치 수를 계산
        int result = fibonacci(number);
        System.out.println("Fibonacci number at position " + number + " is " + result);
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 전위 순회 구현, 동일한 로직 핵심
    void preorder(Node root) {
        if (root == null) return;
        System.out.println(root);
//        preorder(root.left);
//        preorder(root.right);
    }
}
