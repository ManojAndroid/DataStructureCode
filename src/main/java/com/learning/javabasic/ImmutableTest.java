package com.learning.javabasic;

import com.learning.java8.Student;

public class ImmutableTest {
    public static void main(String[] args) {

        Student student1 = new Student(1, "nn", 20, "sss");
        FullyImmutableClass fullyImmutableClass = new FullyImmutableClass("manoj", 12, student1);
        System.out.println("befor changes" + fullyImmutableClass.getStudent());
        student1.setAddress("trsting");
        System.out.println("after changes" + fullyImmutableClass.getStudent());

    }

}







