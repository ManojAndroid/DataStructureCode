package com.learning.java8;

public class CustomAdderFunction {
    public static void main(String[] args) {
        Adder<String, String, String> adder = (a, b) -> a + b;
        String  sum = adder.add("aaa", "b");
        AddInteger addInteger= new AddInteger();
        System.out.println(addInteger.add(4,5));
        System.out.println(sum);
        System.out.println("----- simple-");
        AdderSimple adderSimple=(a,b)->a+b;
        System.out.println(adderSimple.add(2,3));
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
interface AdderSimple
{
    int add( int a,int b);
}




