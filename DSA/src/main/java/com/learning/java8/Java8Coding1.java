package com.learning.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Coding1 {

    public static void find3LargetElement(int[] arr) {
        Arrays.stream(arr).boxed().sorted((a, b) -> b - a).limit(3).forEach(n -> System.out.print(n + ", "));
    }

    public static void find2nLargestElement(int[] arr) {
        Integer val = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).skip(1).findFirst().orElse(null);
        System.out.println(" 2nd largest no " + val);
    }

    public static void sortWordBasedOnLength() {
        List<String> nameList = Arrays.asList("Mk", "Manoj", "AAkash", "Riya");
        nameList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(name -> System.out.println(name + ","));
    }

    public void grouping() {
        List<Employee> list = Arrays.asList(new Employee("aRUN", " IT", 200.0),
                new Employee("manoj", " IT", 200.0),
                new Employee("abc", " EC", 200.0),
                new Employee("def", "ECE", 200.0));

        Map<String, List<String>> mapBydept = list.stream().collect(Collectors.groupingBy(Employee::getDept,
                // Transform values to employee names
                Collectors.mapping(Employee::getName, Collectors.toList())));

        Map<String, List<Employee>> mapByDept = list.stream()
                // Group by department
                .collect(Collectors.groupingBy(Employee::getDept,
                        // Transform each employee to a new Employee object with only name and salary
                        Collectors.mapping(e -> new Employee(e.getName(), null, e.getSalary()), Collectors.toList())));
        System.out.println(mapBydept);

    }

    private static void findMinAndMax() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int max = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(" max Value: " + max);

        int min = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Min value: " + min);

        System.out.println("To find min and max from list of characters :");

        List<Character> chars = Arrays.asList( 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' );
        char ch=chars.stream().min(Comparator.comparing(Character::charValue)).get();//use max for max
        System.out.println("character :"+ ch);

        System.out.println("To find min and max from list of String values :");
        List<String> names = Arrays.asList( "Biden", "Putin", "Modi", "Ali", "Jack" );
        String name=names.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("Find the max value from String "+ name);
    }

    public static void reduceMethod(){
//https://www.benchresources.net/java-8-stream-reduce-method-with-examples/
        int[] intArray = { 17, 23, 29, 31, 37, 41, 43, 47, 53, 58 };
        int sum= Arrays.stream(intArray).reduce(0,Integer::sum);
        System.out.println(" Sum Using Reduce :"+sum);
        // 1.2 reduce() - subtract using Lambda Expression
        int sub= Arrays.stream(intArray).reduce(0,(a,b)->a-b);
        System.out.println(" sub "+ sub);

        // 1.4 reduce() - division using Lambda Expression
        int div= Arrays.stream(intArray).reduce(0,(a,b)->a/b);
        System.out.println(" div "+ div);
    }
    public  static void countMethod(){
        List<String> sectors = Arrays.asList( "Motor", "Power", "Steel", "Chemicals", "Capital" );
        long count=sectors.stream().count();
        System.out.println(" count" + count);
        System.out.println("Count elements after removing duplicates ");
        List<Integer> numbers = Arrays.asList( 1, 2,2, 3,3,3, 4,4,4,4, 5,5,5,5,5 );
        long count1= numbers.stream().distinct().count();
        System.out.println("Count :"+ count1);
    }

    public static void main(String[] args) {
        countMethod();
       // reduceMethod();
      //  int arr[] = {10, 4, 3, 50, 23, 90};
        //find3LargetElement(arr);
        //find2nLargestElement(arr);
        //sortWordBasedOnLength();
        //findMinAndMax();

    }
}

class Employee {
    String name;
    String dept;
    Double salary;

    public Employee(String name, String dept, Double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
