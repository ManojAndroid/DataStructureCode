package com.learning.CompanyQuestion;

public class Fibonacci {
 static void printFibo(int n)
 {
    int n1=0, n2=1;
   System.out.print(n1);
   for(int i=1;i<n;i++)
   {
     System.out.print(n2);
     int next=n1+n2;
     n1=n2;
     n2=next;
   }
 }

  public static void main(String[] args) {
    printFibo(7);
  }
}
