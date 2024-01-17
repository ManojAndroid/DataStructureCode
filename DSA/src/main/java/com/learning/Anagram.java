package com.learning;

import java.util.Arrays;
public class Anagram {

    //using sorting
    static boolean isAnagram(char [] s1, char []s2){
        int s1Length=s1.length;
        int s2Length=s2.length;
        if(s1Length!=s2Length)
            return false;
        Arrays.sort(s1);
        Arrays.sort(s2);

        for(int i=0;i<s1Length;i++)
        {
            if(s1[i]!=s2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char str1[] = {'r', 'a', 'm' };
        char str2[] = { 'a', 'r', 'm' };

        // Function Call
        if (isAnagram(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }
}
