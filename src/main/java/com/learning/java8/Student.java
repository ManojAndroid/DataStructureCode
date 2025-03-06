package com.learning.java8;

import java.util.List;

public class Student {
    int id;
    String name;
    int age;
    String address;
    List<Hobbies> hobbiesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Hobbies> getHobbiesList() {
        return hobbiesList;
    }

    public void setHobbiesList(List<Hobbies> hobbiesList) {
        this.hobbiesList = hobbiesList;
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(int id, String name, int age, String address, List<Hobbies> hobbiesList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbiesList = hobbiesList;
    }

    String tostring() {
        return "id: " + id + " name: " + name + " age: " + age + " address: " + address;
    }

}

class Hobbies{
    String hobbieName;
    String hobbieId;

    public String getHobbieName() {
        return hobbieName;
    }

    public void setHobbieName(String hobbieName) {
        this.hobbieName = hobbieName;
    }

    public String getHobbieId() {
        return hobbieId;
    }

    public void setHobbieId(String hobbieId) {
        this.hobbieId = hobbieId;
    }

    public Hobbies(String hobbieName, String hobbieId) {
        this.hobbieName = hobbieName;
        this.hobbieId = hobbieId;
    }

    public Hobbies() {
    }
}
