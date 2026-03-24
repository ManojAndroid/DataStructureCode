package com.learning.java21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("print thread :" + Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(task);
        }
        // sleep main thread
        Thread.sleep(1000);

        // using exexutor service

        try(ExecutorService executor= Executors.newVirtualThreadPerTaskExecutor())
        {
            for (int i = 0; i < 5; i++) {
                executor.execute(()-> System.out.println(" executor  thread :" + Thread.currentThread()));
                // use submit to return the value
                //executor.submit(()-> System.out.println(" executor  thread :" + Thread.currentThread()));
            }
        }

    }

}
