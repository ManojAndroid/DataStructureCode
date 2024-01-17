package com.learning.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Java8BasicQuestion {

    static void iterateMapJava8(Map<String, String> map){
        map.forEach((k,v)-> System.out.println(" java 8 Key: "+k+" Value: "+v));
    }

    static void iterateMapJavaNorma(Map<String, String> map){

        for(Map.Entry<String,String>  set: map.entrySet()){
            System.out.println(" normal value: "+set.getKey()+"value: "+set.getValue());
        }
    }
    static void grouping(List<Student> list){
        Map<String, List<Student>> result=list.stream().collect(groupingBy(student -> student.address));
        result.forEach((k,v)-> {
            System.out.println(" key: "+k);
            v.forEach(student -> System.out.println("value:"+student.tostring()));
        });
    }

    static void map(List<Student> list){
        List<String> result=list.stream().map(data->data.address).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void sum(List<Student> list){
        int  sum=list.stream().collect(Collectors.summingInt(student -> student.age));
        System.out.println("sum: "+sum);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Ball");
        map.put("C", "Cat");
        iterateMapJava8(map);
        System.out.println(" ----------------- ");
        iterateMapJavaNorma(map);

        List<Student> list=new ArrayList<>();
        list.add(new Student(1,"A",12,"delhi"));
        list.add(new Student(2,"B",13,"delhi"));
        list.add(new Student(3,"C",14,"Pune"));
        list.add(new Student(4,"D",15,"Pune"));

        System.out.println(" ----------------- ");
        grouping(list);

        System.out.println(" ----------------- map ");
        map(list);

        System.out.println(" ----------------- sum ");
        sum(list);

    }

}
class Student{
    int id;
    String name;
    int age;
    String address;
    public Student(int id, String name, int age, String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }
    String tostring(){
        return "id: "+id+" name: "+name+" age: "+age+" address: "+address;
    }
}
