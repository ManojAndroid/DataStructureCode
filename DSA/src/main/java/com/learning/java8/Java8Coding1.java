package com.learning.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Coding1 {

    public static void find3LargetElement(int [] arr){
        Arrays.stream(arr).boxed().sorted((a,b)->b-a).limit(3).forEach(n->System.out.print(n+", "));
    }
    public static void find2nLargestElement(int [] arr){
        Integer val=Arrays.stream(arr).boxed().sorted((a,b)->b-a).skip(1).findFirst().orElse(null);
        System.out.println(" 2nd largest no "+ val);
    }

    public static void sortWordBasedOnLength(){
        List<String> nameList= Arrays.asList("Mk","Manoj","AAkash","Riya");
        nameList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(name-> System.out.println(name+","));
    }


    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 23, 90};
        //find3LargetElement(arr);
        //find2nLargestElement(arr);
        sortWordBasedOnLength();
    }
}
