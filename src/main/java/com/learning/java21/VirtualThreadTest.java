package com.learning.java21;

public class VirtualThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("print thread :" + Thread.currentThread());

        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(task);
        }
        // sleep main thread
        Thread.sleep(1000);

        // using exexutor service

    }

}
