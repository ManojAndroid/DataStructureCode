package com.learning.Instagram;

public class TestingEqualObject {

  public static void main(String[] args) {
    UserDetails u1=new UserDetails();
    u1.setName("manoj");
    u1.setId(4);

    UserDetails u2=new UserDetails();
    u2.setName("manoj");
    u2.setId(5);

    System.out.println("compare vale"+(u1==u2));
  }

}
