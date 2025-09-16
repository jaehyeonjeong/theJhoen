package procon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // 버퍼 크기 5

    public static void main(String[] args) {
        ProducerConsumerWithBlockingQueue pc = new ProducerConsumerWithBlockingQueue();

        // 생산자 스레드
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pc.queue.put(i); // 큐가 가득 차면 자동으로 대기
                    System.out.println("생산: " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 소비자 스레드
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int value = pc.queue.take(); // 큐가 비면 자동으로 대기
                    System.out.println("소비: " + value);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
