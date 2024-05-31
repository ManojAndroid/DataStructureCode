package com.learning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8UseInbuildFunctionalInterface {
    public static void main(String[] args) {
        Consumer<Integer> consumer= a-> System.out.print(a+",");
        List<Integer> lis= Arrays.asList(1,2,3,4,5,6);
        lis.stream().forEach(consumer);
        lis.stream().sorted();
    }
}
