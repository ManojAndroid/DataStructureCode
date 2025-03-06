package clientQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDeplicate {
    public static int removeDuplicates(int[] nums) {

        Map<Integer, Integer> mapCount=new HashMap<>();

        for(int num:nums){
            if(mapCount.getOrDefault(num,0)<2)
                mapCount.put(num,mapCount.getOrDefault(num,0)+1);
        }
        return mapCount.values().stream().mapToInt(a -> a).sum();

    }

    public static void main(String[] args) {
        int [] arr={1,1,1,2,2,3};
        System.out.println("total : "+removeDuplicates(arr));

    }
}
