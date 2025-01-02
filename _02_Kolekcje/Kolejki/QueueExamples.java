package _02_Kolekcje.Kolejki;

import java.util.*;

public class QueueExamples {
    public static void main(String[] args) {
        // FIFO
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("FIFO: " + queue); // [1,2,3]
        System.out.println("Pobieranie queue.poll(): " + queue.poll()); // 1

        // LIFO
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("LIFO: " + stack); // [3,2,1]
        System.out.println("Pobieranie stack.pop(): " + stack.pop()); // 3

        // PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(5);
        pq.add(15);

        System.out.println("PriorityQueue: " + pq); // [5, 20, 15]
        System.out.println("Pobieranie z pq.poll(): " + pq.poll()); //5
    }
}
