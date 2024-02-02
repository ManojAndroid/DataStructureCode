package com.learning;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValueJava8 {

    public static void sortMapByValue(Map<String, Integer> map) {


        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        //NOTE use LinkedHashMap::new to maintained insertion order other wise it will give same object
        sortedMap.forEach((k, v) -> System.out.println("Key: " + k + " Value :" + v));
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 2);
        map.put("B", 3);
        map.put("C", 1);
        sortMapByValue(map);

    }
}
