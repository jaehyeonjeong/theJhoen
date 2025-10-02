package datastruct;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeQueueMain {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);      // 선입 선출 구조(First In First Out)

        System.out.println("queue.peek() === " + queue.peek());
        System.out.println("queue.poll() === " + queue.poll());
        System.out.println("queue.poll() === " + queue.poll());
        System.out.println("queue.poll() === " + queue.poll());
        System.out.println(queue);
    }
}
