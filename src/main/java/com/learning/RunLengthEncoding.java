package com.learning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncoding {

    public static String encode(String str) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        charMap.forEach((k, v) -> {
            strBuilder.append(k).append(v);
        });
        return strBuilder.toString();



    }

    public static void main(String[] args) {
        String str = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
        System.out.println(encode(str));//w4a3d1e1x6y1w3
    }
}
