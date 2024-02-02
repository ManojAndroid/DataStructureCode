package com.learning.javabasic;

import com.learning.java8.Student;

public class ImmutableTest {
    private final Student student;

    private ImmutableTest(Student student) {
        this.student = student;
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "nn", 20, "sss");
        ImmutableTest s = new ImmutableTest(student1);
        System.out.println(s);
        student1.setAge(30);
        System.out.println(student1);

    }

}







