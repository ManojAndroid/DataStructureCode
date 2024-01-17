package com.learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NutBoltMatching {

  //The time complexity for this solution is O(n).
  static void nutBoltMatching(char[] nuts, char[] bolts) {
    Map<Character, Integer> mapSet = new HashMap<>();

    for (int i = 0; i < nuts.length; i++) {
      mapSet.put(nuts[i], i);
    }
    for (int i = 0; i < bolts.length; i++) {
      if (mapSet.containsKey(bolts[i])) {
        nuts[i] = bolts[i];
      }
    }
    for (char nut : nuts) {
      System.out.print(nut + " ");
    }

    System.out.println();

    for (char bolt : bolts) {
      System.out.print(bolt + " ");
    }
  }


  static void matchPairs(char nuts[], char bolts[], int n) {

    Set<Character> setValue= new HashSet<>();

    for(char nut: nuts)
    {
      setValue.add(nut);
    }

    for(char bolt: bolts){
      if(setValue.contains(bolt)){
        System.out.print("bolt : "+bolt +" nut:"+bolt);
        System.out.println("");
      }
    }


    // code here
  }

  public static void main(String[] args) {
    char nuts[] = {'@', '#', '$', '%', '^', '&'};
    char bots[] = {'$', '%', '&', '^', '@', '#'};
   nutBoltMatching(nuts, bots);
    System.out.println("------------");
    matchPairs(nuts, bots, nuts.length);
  }
}
