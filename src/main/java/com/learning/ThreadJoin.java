package com.learning;

public class ThreadJoin {
  public static void main(String[] args) throws InterruptedException {

    Thread t1=new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + " ");

      }
    });

    Thread t2=new Thread(() -> {
      for(int i=11;i<=20;i++)
      {
        System.out.println(i+" ");
      }
    });

    t1.start();
    t1.join();
    t2.start();

  }
}



