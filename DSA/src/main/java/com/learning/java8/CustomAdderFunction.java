package com.learning.java8;

public class CustomAdderFunction {
    public static void main(String[] args) {
        Adder<String, String, String> adder = (a, b) -> a + b;
        String  sum = adder.add("aaa", "b");
        AddInteger addInteger= new AddInteger();
        System.out.println(addInteger.add(4,5));
        System.out.println(sum);
    }
}


@FunctionalInterface
interface Adder<A, B, R> {
    R add(A param1, B param2);
}

class AddInteger implements Adder<Integer, Integer, Integer> {
    @Override
    public Integer  add(Integer param1, Integer param2) {
        return param1 + param2;
    }
}




