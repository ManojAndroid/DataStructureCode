package clientQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
//tc overall time complexity is 𝑂 ( 𝑛 2 )
    public static int wordBreak(String s, List<String> dictionary )
    {
        if(helper(s,dictionary)) return 1;
        else return 0;
    }

    static  boolean helper(String s, List<String> dict){
        if(s.isEmpty()) return true;
        for(int i=0;i<s.length();i++){
            String temp=s.substring(0,i+1);
            if(dict.contains(temp)){
                String rem=s.substring(i+1);
                if(helper(rem,dict)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str="ilike";
        List<String> list= Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile");
        System.out.println(wordBreak(str,list));
    }
}
