package ConcurrencyProblem;

import java.util.concurrent.CountDownLatch;

public class Number10and1020Printer {
    CountDownLatch count = new CountDownLatch(1);

    public void print1to10() {

        for (int i = 1; i <= 10; i++) {
            System.out.println("thread-1 : " + i);
        }
        count.countDown();
    }

    public void print11to20() throws InterruptedException {
        count.await();// waitt to complete 1 to 10
        for (int i = 11; i <= 20; i++) {
            System.out.println("thread-2 : " + i);
        }
    }

    public static void main(String[] args) {
        Number10and1020Printer ptr = new Number10and1020Printer();
        Thread t1 = new Thread(() -> ptr.print1to10());
        Thread t2 = new Thread(() -> {
            try {
                ptr.print11to20();
            } catch (Exception e) {

            }
        });
        t1.start();
        t2.start();
    }


}
