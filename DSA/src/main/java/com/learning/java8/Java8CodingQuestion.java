package com.learning.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8CodingQuestion {
    public static  void wordCounter(){
        String sentence = "This is a sentence with multiple words . Words are repeated multiple times.".toLowerCase();
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(word->word,Collectors.counting()))
                .forEach((k,v)-> System.out.println("key: " +k+ " value: " +v));
    }

    public static  void wordSort(){
        String sentence = "This is a sentence with multiple words . Words are repeated multiple times.".toLowerCase();
        String sorted =Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.joining(" "));
        System.out.println("sorted string : " +sorted);
    }
    static void find3rdLargestNumber(){
        List<Integer> numbers=Arrays.asList(1,3,2,5,6,7,9);
        Integer result=numbers.stream().sorted((a,b)->b.compareTo(a)).skip(2)
                .findFirst().orElse(null);
        System.out.println("find3rdLargestNumber"+result);
    }

    public static void main(String[] args) {
        //wordCounter();
        System.out.println("sort based on length");
        wordSort();
        System.out.println("3 largest number");
        find3rdLargestNumber();
    }
}
