package join;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class join02Main {
    public static void main(String[] args) {
        log("start");
        SumTask sumTask01 = new SumTask(1, 500);
        SumTask sumTask02 = new SumTask(501, 1000);


        Thread thread01 = new Thread(sumTask01, "thread1");
        Thread thread02 = new Thread(sumTask02, "thread2");

        // 1 ~ 1000 10초 걸리는 일 1부터 500까지 1번, 501~1000 2번
        thread01.start();
        thread02.start();  // thread02가 시작을 못 할수 있다.
        // 중요 : main Thread는 대기를 하지 않는다.
        // sumtask가 2초 걸리는 작엄을 기다리지 않는다. 왜냐 스레드는 모두 독립적이기 때문에

        // main을 재워보자
        log("main 스레드 sleep()");
        sleep(3000);
        log("main 스레드 깨어남");

        // sleep으로 잠궈 버려서 결과가 0밖에 나오지 않음
        log("sumTask01.result = " + sumTask01.result);
        log("sumTask02.result = " + sumTask02.result);
        int sumAll = sumTask01.result + sumTask02.result;
        log("sumTask01 + sumTask02 = " + sumAll);
        log("end");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            // 대략 2초정도 걸리는 작업을 한다는 가정
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for(int i = startValue; i < endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
