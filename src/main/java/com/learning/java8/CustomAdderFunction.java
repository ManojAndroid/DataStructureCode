package com.learning.java8;

public class CustomAdderFunction {
    public static void main(String[] args) {
        Adder<String> adder = (a, b) -> a + b;
        String  sum = adder.add("aaa", "b");
        AddInteger addInteger= new AddInteger();
        System.out.println(addInteger.add(4,5));
        System.out.println(sum);
    }
}


@FunctionalInterface
interface Adder<T> {
    T add(T param1, T param2);
}

class AddInteger implements Adder<Integer> {
    @Override
    public Integer  add(Integer param1, Integer param2) {
        return param1 + param2;
    }
}




