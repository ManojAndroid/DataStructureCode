package com.learning;

import java.util.Arrays;
import java.util.List;

public class ConvertDecimalToRoman {
    /* Time complexity: O(1)
     Space complexity: O(1)
     decimalToRoman function iterates a fixed number of times (13 times to be precise
     */
    public static String decimalToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "VI", "I"};
        String result = "";
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number = number - values[i];
                result = result + roman[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
       // System.out.println(decimalToRoman(2465));//MMCDLXV

        List<Integer> list= Arrays.asList(1,2,3,4,1);
        //list.remove(1);
        System.out.println(list);
    }
}
