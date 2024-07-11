package week2.study;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        // enqueue
        q.add(1); // q: [1]
        q.add(2); // q: [1, 2]
        q.add(3); // q: [1, 2, 3]

        // front, dequeue
        System.out.println(q.peek()); // 출력: 1 // q: [1, 2, 3]
        System.out.println(q.remove()); // 출력: 1 // q: [2, 3]
        System.out.println(q.remove()); // 출력: 2 // q: [3]

        // enqueue
        q.add(4); // q: [3, 4]
        q.add(5); // q: [3, 4, 5]

        // empty
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}