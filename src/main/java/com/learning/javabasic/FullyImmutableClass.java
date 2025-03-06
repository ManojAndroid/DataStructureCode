package com.learning.javabasic;

import com.learning.java8.Student;

import java.util.ArrayList;

public final class FullyImmutableClass {
    private final String name;
    private final int age;
    private final Student student;

    // Private constructor
    public FullyImmutableClass(final String name, final int age, final Student student) {
        this.name = name;
        this.age = age;
        // Create a defensive copy or use an immutable version of the Student class
        //this.student=student;
        this.student = new Student(student.getId(), student.getName(), student.getAge(), student.getAddress());
    }

    // Static factory method to create instances
    public static FullyImmutableClass create(String name, int age, Student student) {
        return new FullyImmutableClass(name, age, student);
    }

    // Getter methods for each field
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Return a copy or an immutable version of the Student object
    public Student getStudent() {
        return  student;
       // return new Student(student.getId(), student.getName(), student.getAge(), student.getAddress());
    }
}
