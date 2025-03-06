package com.learning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExample {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "manoj", 30, "bhandar"));
        studentList.add(new Student(3, "Akash", 34, "udaygarh"));
        studentList.add(new Student(2, "bikash", 29, "chhattarpur"));

        Comparator<Student> sortByName = Comparator.comparing(Student::getName);
        Collections.sort(studentList, sortByName);

        System.out.println("Sorting by name using comparator---------");
        studentList.forEach(student -> System.out.println(student.name + ","));

        Comparator<Student> sortByName1 = Comparator.comparing(Student::getName);
        studentList.sort(sortByName1);

        System.out.println("Sorting by name using comparator and sort---------");
        studentList.forEach(student -> System.out.println(student.name + ","));

        List<Student> studentList1 = studentList.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());

        System.out.println("Sorting by id using comparator---------");
        studentList1.forEach(student -> System.out.print(student.id + ","));


    }
}
