package com.learning.java8;

public class PrintSequence {
    private static final Object lock = new Object();
    private static int current = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> printSequence(1));
        Thread thread2 = new Thread(() -> printSequence(2));
        Thread thread3 = new Thread(() -> printSequence(3));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void printSequence(int threadNumber) {
        while (true) {
            synchronized (lock) {
                // Check if it's the turn of the current thread to print
                while (current % 3 != threadNumber - 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Print the number and update the current counter
                if (current <= MAX_NUMBER) {
                    System.out.println("Thread " + threadNumber + ": " + current);
                    current++;
                } else {
                    break; // Exit the loop when the sequence is completed
                }

                // Notify other threads waiting on the lock
                lock.notifyAll();
            }
        }
    }
}
