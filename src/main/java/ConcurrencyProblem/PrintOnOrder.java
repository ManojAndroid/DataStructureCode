package ConcurrencyProblem;


import java.util.concurrent.CountDownLatch;
public class PrintOnOrder {
    CountDownLatch downLatch1 = new CountDownLatch(1);
    CountDownLatch downLatch2 = new CountDownLatch(1);

    public void first(Runnable print1) {
        print1.run();
        downLatch1.countDown();
    }

    public void second(Runnable print2) throws InterruptedException {
        downLatch1.await();
        print2.run();
        downLatch2.countDown();
    }

    public void third(Runnable print3) throws InterruptedException {
        downLatch2.await();
        print3.run();
    }

    public static void main(String[] args) {
        PrintOnOrder printOnOrder = new PrintOnOrder();
        Thread thread1 = new Thread(() -> printOnOrder.first(() -> System.out.println("printfirst")));
        Thread thread2 = new Thread(() -> {
            try {
                printOnOrder.second(() -> System.out.println("printsecond"));
            } catch (Exception e) {
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                printOnOrder.second(() -> System.out.println("printthird"));
            } catch (Exception e) {
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
