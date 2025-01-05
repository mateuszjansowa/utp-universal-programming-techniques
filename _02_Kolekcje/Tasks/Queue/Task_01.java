package _02_Kolekcje.Tasks.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task_01 {
    public static void main(String[] args) {
        Queue<String> regularQueue = new ArrayDeque<>();
        Queue<String> vipQueue = new ArrayDeque<>();

        regularQueue.add("Zwykły-Kowalski");
        regularQueue.add("Zwykły-Lewandowski");
        vipQueue.add("VIP-Nowak");
        vipQueue.add("VIP-Kaczmarek");

        while (!vipQueue.isEmpty()) {
            System.out.println(vipQueue.poll());
        }

        while (!regularQueue.isEmpty()) {
            System.out.println(regularQueue.poll());
        }
    }
}
