package com.learning.java8;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingCharacter {
    static void firstRepeatingChar(String str){
        Set<Character> set=new HashSet<>();
         Optional<Character> result=str.chars().mapToObj(c->(char)c).filter(cha->!set.add(cha)).findFirst();
        result.ifPresent(System.out::println);
//or
        Character firstRepa=str.chars().mapToObj(c->(char)c).filter(cha->!set.add(cha)).findFirst().orElse(null);
        System.out.println(firstRepa);
    }

    public static char findFirstNonRepeatingCharacter(String str) {
        /*char ans=str.chars().mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(Character::charValue,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('\n');*/
        //or
        // Use Java 8 streams to find the first non-repeating character
        Map<Character, Long> charCountMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));

        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> charCountMap.get(c) == 1)
                .findFirst()
                .orElse('\0'); // Default value if no non-repeating character is found
    }

    public static void main(String[] args) {
        firstRepeatingChar("manoj singh");


        String input = "programmingp";
        char firstNonRepeatingChar = findFirstNonRepeatingCharacter(input);

        if (firstNonRepeatingChar != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeatingChar);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
}
