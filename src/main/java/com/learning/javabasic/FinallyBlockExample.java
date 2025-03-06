package com.learning.javabasic;

public class FinallyBlockExample {
    int absorbeTheValue() {
        try {
            int a = 10 / 1;
            //System.exit(1);// finally bloc will not execute
            return a;
        } catch (Exception e) {
            return 45;
            //throw new RuntimeException("something happend");// finally block will get executed
        } finally {
           // return 34;
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int result = new FinallyBlockExample().absorbeTheValue();
        System.out.println(result);
    }
}
