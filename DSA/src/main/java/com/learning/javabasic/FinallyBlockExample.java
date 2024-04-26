package com.learning.javabasic;

public class FinallyBlockExample {
    int absorbeTheValue() {
        try {
            int a = 10 / 0;
            //System.exit(1);// finally bloc will not execute
            return 4;
        } catch (Exception e) {
            //return 45;
            throw new RuntimeException("something happend");// finally block will get executed
        } finally {
            return 34;
        }
    }

    public static void main(String[] args) {
        int result = new FinallyBlockExample().absorbeTheValue();
        System.out.println(result);
    }
}
