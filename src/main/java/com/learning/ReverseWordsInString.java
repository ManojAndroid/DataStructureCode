package com.learning;

public class ReverseWordsInString {
    public static String reverseWords(String s) {

        String[] arr = s.split("\\s+");
        String result = "";

        for (String str : arr) {
            if (str == " ")
                continue;
            if (result == "")
                result = str;
            else
                result = str + " " + result;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "a good   example";
        String result = reverseWords(str);
        System.out.println(result);
    }
}
