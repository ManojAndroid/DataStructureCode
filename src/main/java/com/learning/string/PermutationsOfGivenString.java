package com.learning.string;

public class PermutationsOfGivenString {

    static void permute(String str, String prefix) {

        if (str.length() == 0) {
            System.out.print(prefix+",");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String newPrefix = prefix + str.charAt(i);
            String newRemaining = str.substring(0, i) + str.substring(i + 1);
            permute(newRemaining, newPrefix);
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        String answer = "";
        System.out.print("\nAll possible strings are : ");
        permute(s, answer);
    }
}
