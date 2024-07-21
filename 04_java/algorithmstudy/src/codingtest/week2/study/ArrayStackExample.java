package codingtest.week2.study;

import java.util.*;

public class ArrayStackExample {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        // push
        stack.push(1); // s: [1]
        stack.push(2); // s: [2, 1]
        stack.push(3); // s: [3, 2, 1]

        // top, pop
        System.out.println(stack.peek()); // 출력: 3 // s: [3, 2, 1]
        System.out.println(stack.pop()); // 출력: 3 // s: [2, 1]
        System.out.println(stack.pop()); // 출력: 2 // s: [1]

        // push
        stack.push(4); // s: [4, 1]
        stack.push(5); // s: [5, 4, 1]

        // empty
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
