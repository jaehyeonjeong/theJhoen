package procon;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            wait(); // 버퍼가 가득 찼으면 대기
        }
        buffer.add(value);
        System.out.println("생산: " + value);
        notify(); // 소비자에게 알림
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // 버퍼가 비었으면 대기
        }
        int value = buffer.poll();
        System.out.println("소비: " + value);
        notify(); // 생산자에게 알림
        return value;
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        // 생산자 스레드
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pc.produce(i);
                    Thread.sleep(100); // 생산 속도 조절
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 소비자 스레드
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pc.consume();
                    Thread.sleep(150); // 소비 속도 조절
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
