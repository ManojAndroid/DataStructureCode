package com.learning.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Java8BasicQuestion {

    static void iterateMapJava8(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(" java 8 Key: " + k + " Value: " + v));
    }

    static void iterateMapJavaNorma(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println(" normal value: " + set.getKey() + "value: " + set.getValue());
        }
    }

    public static void sortByValue(Map<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());
        // Sort the list
        Collections.sort(list, Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        for (Map.Entry<String, Integer> set : temp.entrySet()) {
            System.out.println(" normal value: " + set.getKey() + "value: " + set.getValue());
        }
    }

    static void grouping(List<Student> list) {
        Map<String, List<Student>> result = list.stream().collect(Collectors.groupingBy(Student::getAddress));
        result.forEach((k, v) -> {
            System.out.println(" key: " + k);
            v.forEach(student -> System.out.println("value:" + student.tostring()));
        });
    }

    static void map(List<Student> list) {
        List<String> result = list.stream().map(Student::getAddress).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void flatMap() {
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("One", "Two", "Three"), Arrays.asList("Four", "Five", "Six"));
        // Using flatMap to flatten the lists of lists into a single list
        List<String> flatList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        // Result: ["One", "Two", "Three", "Four", "Five", "Six"]
    }

    public static void convertListToMap() {
        List<Student> people = new ArrayList<>();
        people.add(new Student(1, "Alice", 25, "Address1"));
        people.add(new Student(2, "Bob", 30, "Address2"));
        people.add(new Student(4, "Charlie", 35, "Address3"));
        // Convert the list to a Map with ID as key and Address as value
        Map<Integer, String> studentAddressMap = people.stream().collect(Collectors.toMap(Student::getId, Student::getAddress));
    }

    static void sortMapBasedOnValue() {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Alice", 30);
        unsortedMap.put("Bob", 25);
        unsortedMap.put("Charlie", 35);
        unsortedMap.put("David", 28);

        // Sort the Map by values in ascending order
        Map<String, Integer> sortedMapAsc = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Print the sorted Map in ascending order
        System.out.println("Sorted Map (Ascending Order): " + sortedMapAsc);

        // Sort the Map by values in descending order
        Map<String, Integer> sorted = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        // Print the sorted Map in descending order
        System.out.println("Sorted Map (Descending Order): " + sorted);
    }

    static void sum(List<Student> list) {
        int sum = list.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("sum: " + sum);
    }

    static void printListOfUniqueHobbie(List<Student> studentList){
        List<String> uniqueHobbie=studentList.stream().flatMap(student -> student.getHobbiesList().stream()).map(Hobbies::getHobbieName).distinct().collect(Collectors.toList());
        System.out.println(uniqueHobbie);
    }

    static void arrayToStreamAndFilter()
    {int [] arr={2,2,3,3,3,4,4,4};
        List<Integer> filteredData=Arrays.stream(arr)
                .filter(data->data==3).boxed()
                .collect(Collectors.toList());}

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        iterateMapJava8(map);
        System.out.println(" ----------------- ");
        iterateMapJavaNorma(map);

        List<Student> list = new ArrayList<>();
        List<Hobbies> student1Addresss = new ArrayList<>();
        student1Addresss.add(new Hobbies("cricket", "1"));
        student1Addresss.add(new Hobbies("bollywball", "1"));

        List<Hobbies> student2Addresss = new ArrayList<>();
        student1Addresss.add(new Hobbies("cricket", "1"));
        student1Addresss.add(new Hobbies("footbal", "1"));

        List<Hobbies> student3Addresss = new ArrayList<>();
        student1Addresss.add(new Hobbies("cricket", "1"));
        student1Addresss.add(new Hobbies("footbal", "1"));

        list.add(new Student(1, "A", 12, "delhi", student1Addresss));
        list.add(new Student(2, "B", 13, "delhi", student2Addresss));
        list.add(new Student(3, "C", 14, "Pune", student3Addresss));

      /*  System.out.println(" ----------------- ");
        grouping(list);

        System.out.println(" ----------------- map ");
        map(list);

        System.out.println(" ----------------- sum ");
        sum(list);


        System.out.println(" ----------------- sort map using simple ");
        sortByValue(map);*/


        System.out.println(" ----------------- sort map using simple ");
        sortByValue(map);


        System.out.println(" ----------------- sort map using java 8 ");
        sortMapBasedOnValue();


        System.out.println("fetch filter");
        printListOfUniqueHobbie(list);

    }

}

