package clientQuestion;

import java.util.Arrays;

public class Minimisethemaximumdifferencebetweenheights {
    //https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
    //tc=0(nlogn);
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans=arr[n-1]-k-arr[0]+k;

        int smallest=arr[0]+k;
        int largest=arr[n-1]-k;
        int cSmallest=0;//current smallest
        int cLargest=0;//current largest

        for(int i=0;i<n-1;i++)
        {
            cSmallest=Math.min(smallest,arr[i+1]-k);
            cLargest=Math.max(largest,arr[i]+k);
            if(cSmallest<0)
                continue;
            ans=Math.min(ans,cLargest-cSmallest);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
