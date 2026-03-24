package com.learning.java21;

public class RecordPatternExample {
    public static void main(String[] args) {
        User  user =new User("Manoj",1);
// instanceof user recode
        if(user instanceof User(String name, int userId)){
            System.out.println(name +" : "+userId);
        }
    }

}
record User (String name,int userId){

}
