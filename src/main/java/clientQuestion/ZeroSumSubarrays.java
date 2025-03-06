package clientQuestion;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {
    public static long findSubarray(long[] arr ,int n) {
        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
        int sum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0)
                cnt++;
            if(mp.containsKey(sum)){
                cnt+=mp.get(sum);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        long [] arr={0,0,5,5,0,0};
        int n=arr.length;
        System.out.println(findSubarray(arr,n));
    }
}
