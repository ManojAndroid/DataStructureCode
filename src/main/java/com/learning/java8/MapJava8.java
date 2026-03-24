package com.learning.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapJava8 {

    public static void countCharAndSortInReverseOrder(List<String> names){
        Map<Character,Long> mapcount= names.stream().flatMapToInt(String::chars)
                .mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Character,Long>comparingByValue()
                        .reversed()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (e1,e2)->e1,
                        LinkedHashMap::new));

        mapcount.forEach((k,v)->{
            System.out.println("key : "+k+"value :"+v);
        });
    }

    public static void getMaxCountChar(List<String> names) {
        Map.Entry<Character, Long> maxEntry =
                names.stream()
                        .flatMapToInt(String::chars)
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue()).get();

        System.out.println("Max char: " + maxEntry.getKey() +
                ", Count: " + maxEntry.getValue());
    }

    public static void main(String[] args) {
        List<String> name= Arrays.asList("dd","AAAA","BBB","CC");
      //countCharAndSortInReverseOrder(name);

        System.out.println(" maxcount char");
        getMaxCountChar(name);
    }
}
