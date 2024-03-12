package com.learning;

import java.util.ArrayList;
import java.util.List;

public class PatternSearchingUsingZAlgorithm {
    public static List< Integer > search(String s, String pattern){
       List<Integer> result=new ArrayList<>();
       int index=s.indexOf(pattern);
       while (index!=-1){
           result.add(index+1);
           index=s.indexOf(pattern,index+1);
       }
       return result;
    }

    public static void main(String[] args) {
        String value="abdchabd";
        String pattern="abd";

        //‘s’ = “abdchabd”, ‘pattern’ = “abd”
        //Output: 1 6
        List<Integer> result=search(value,pattern);
        result.stream().forEach(System.out::println);
    }
}
