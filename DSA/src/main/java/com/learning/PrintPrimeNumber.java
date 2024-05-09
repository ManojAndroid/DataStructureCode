package com.learning;

public class PrintPrimeNumber {
    // prime no divisible by itself ans 1;

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {// if no 16 then it will divisible till from 2 to till 8 only
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

}
