package com.learning.javabasic;

import com.learning.java8.Student;

import java.util.HashMap;
import java.util.Map;

public class MapBasic {
    public static void main(String[] args) {
        Student student=new Student(1,"name",30,"sss");
        Map<Student,Boolean> map=new HashMap<>();
        map.put(student,true);
        System.out.println(map.get(student));
        student.setAddress("changes");
        map.put(student,false);
        System.out.println(map.get(student));


    }
}
