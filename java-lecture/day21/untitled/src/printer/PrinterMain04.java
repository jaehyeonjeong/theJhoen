package printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static utils.MyLogger.log;

public class PrinterMain04 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요. 종료 (q) : ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                thread.interrupt();
//                break;
            }
            printer.addJob(input);
        }
    }

    // sleep(), join(), interrupt()의 사용을 통해 바로 종료되게끔 진행
    static class Printer implements Runnable {

        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    Thread.yield();         // 데이터가 비어있으면 스레드를 양보한다.
                    continue;
                }
                try {
                    String job = jobQueue.poll(); // 끄집어 낸다.
                    log("출력 시작 : " + job + " , 대기중인 문서 :" + jobQueue);
                    Thread.sleep(3000);
                    log("출력 완료 : " + job);
                }catch (InterruptedException e) {
                    log("인터럽트 : " + Thread.currentThread().isInterrupted());
                    log("남아있는 Queue 데이터 : " + jobQueue);
                    log("프린터 종료");
                    break;
                }
            }

//            try {
//                while (!Thread.interrupted()) {
//                    if (jobQueue.isEmpty()) continue;
//                    String job = jobQueue.poll(); // 끄집어 낸다.
//                    log("출력 시작 : " + job + " , 대기중인 문서 :" + jobQueue);
//                    Thread.sleep(3000);
//                    log("출력 완료 : " + job);
//                }
//            } catch (InterruptedException e) {
//                log("인터럽트 : " + Thread.currentThread().isInterrupted());
//            }
//            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
