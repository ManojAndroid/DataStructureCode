package com.learning.java8;

public final class ImmutableClass {

   /* Key characteristics of the ImmutablePerson class:
    final Class: The class is marked as final to prevent it from being subclassed.
    final Fields: The fields name and age are marked as final to make them unmodifiable after object creation.
    No Setter Methods: There are no setter methods in the class. The state can only be set during object construction.
    No Mutable Objects: If the class contains references to mutable objects, those references should be handled carefully to ensure immutability.*/
    private final String name;
    private final int age;

    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ImmutableClass person = new ImmutableClass("John", 30);
        System.out.println(person.hashCode());

        // Attempting to modify the state will result in creating a new object
        // This ensures immutability
        ImmutableClass updatedPerson = new ImmutableClass("Updated John", 31);
        System.out.println(updatedPerson.hashCode());
    }
}
