package datastruct;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        System.out.println("queue.peek() === " + queue.peek());
        int num01 = queue.poll();
        int num02 = queue.poll();
        int num03 = queue.poll();
        System.out.println(num01);
        System.out.println(num02);
        System.out.println(num03);
        System.out.println(queue);
    }
}
