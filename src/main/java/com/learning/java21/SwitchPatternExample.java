package com.learning.java21;

public class SwitchPatternExample {
    public static void main(String[] args) {
        //Object obj="manoj";
        Object obj=1;
       String result= switch (obj)
        {
            case String s -> "hello"+s;
            case Integer i -> " integer"+i;
            default -> "unknown";

        };
        System.out.println(result);
    }
}
