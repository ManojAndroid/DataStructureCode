package clientQuestion;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInt {
    public static int romanToInt(String s) {

        int ans = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            //if current is less than next than subtract
            //else do the sum
            if (i < s.length() - 1 && charMap.get(s.charAt(i)) < charMap.get(s.charAt(i + 1))) {
                ans -= charMap.get(s.charAt(i));
            } else {
                ans += charMap.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="LVIII";
       /* Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.*/
       // System.out.println(romanToInt(str));
        String st="i am manoj    singhee";
        String [] split=st.split("\\s+");
        System.out.println(split[split.length-1].length());
    }
}
