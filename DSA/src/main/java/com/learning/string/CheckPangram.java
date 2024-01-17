package com.learning.string;

import java.util.HashSet;
import java.util.Set;

public class CheckPangram {
  /*  Time Complexity : O(NlogN), for traversing whole string and inserting all the characters at worst case takes logN time.
    Space Complexity : O(1), using constant space for 26 characters at most.*/
    static boolean checkPangram(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                charSet.add(ch);
            }
            if (ch >= 'A' && ch <= 'Z') {
                char lowerCase = Character.toLowerCase(ch);
                charSet.add(lowerCase);
            }
        }
        return charSet.size() == 26;

    }

    public static void main(String[] args) {
        Set<Character> charSet = new HashSet<>();

        charSet.add('c');
        charSet.add('C');


        String str = "The quick brown fox jumps over the lazy dog";
        if (checkPangram(str))
            System.out.println("It is a Pangram");
        else
            System.out.println("It is Not a Pangram");
    }
}
