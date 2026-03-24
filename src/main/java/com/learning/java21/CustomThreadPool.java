package com.learning.java21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Worker[] workers;
    private volatile boolean isShutdown = false;

    public CustomThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker("worker-" + i);
            workers[i].start();// start
        }
    }

    // add task in pool
    public void submit(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool is shutdown");
        }
        taskQueue.offer(task);
    }

    // Shutdown pool
    public void shutDown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.interrupt();
        }

    }

    class Worker extends Thread {

        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();//bloking
                    task.run();
                } catch (InterruptedException e) {
                    // exit if shutdown
                    if (isShutdown)
                        break;
                    //throw new RuntimeException(e);
                } catch (Exception e) {
                    System.out.println("Task error: " + e.getMessage());
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool pool = new CustomThreadPool(3);// pool size 3

        // assigning 10 task;
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Executing Task " + taskId +
                        " by " + Thread.currentThread().getName());
            });
        }
        // shutdown
        System.out.println("main thread"+Thread.currentThread());
        Thread.sleep(1000);
        pool.shutDown();
    }

}

