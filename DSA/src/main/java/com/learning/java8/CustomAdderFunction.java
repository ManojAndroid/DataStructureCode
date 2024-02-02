package com.learning.java8;

public class CustomAdderFunction {
    public static void main(String[] args) {
        Adder<String, String, String> adder = (a, b) -> a + b;
        String  sum = adder.add("aaa", "b");
        System.out.println(sum);
    }
}


@FunctionalInterface
interface Adder<A, B, R> {
    R add(A param1, B param2);
}



