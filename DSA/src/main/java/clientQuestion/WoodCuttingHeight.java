package clientQuestion;

import java.util.Arrays;

public class WoodCuttingHeight {

    public static  int findCuttingHeight(int [] heights,int k){
        int n=heights.length;
        //Arrays.sort() generally uses a modified merge sort algorithm known as TimSort.
        //T O(logn) using binary search;
        int maxHeight = 0;
        for (int height : heights) {
            maxHeight = Math.max(maxHeight, height);
        }

        int left = 0;
        int right = maxHeight;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int woodCollected = getWoodCollected(heights, mid);

            if (woodCollected >= k) {
                result = mid;
                left = mid + 1; // Search for higher cutting height
            } else {
                right = mid - 1; // Search for lower cutting height
            }
        }

        return result;
    }
    private static int getWoodCollected(int[] heights, int cuttingHeight) {
        int woodCollected = 0;
        for (int height : heights) {
            woodCollected += Math.max(0, height - cuttingHeight);
        }
        return woodCollected;
    }



    public static void main(String[] args) {
       /* int[] heights = {7, 4, 9, 2, 1, 8};
        int k = 3;
        int cuttingHeight = findCuttingHeight(heights, k);
        if (cuttingHeight != -1) {
            System.out.println("Height for collecting " + k + " wood: " + cuttingHeight); // Output: 7
        } else {
            System.out.println("No height found");
        }*/
        System.out.println("-----------");
        int [] arr={5,100,111};
        int k=33;
        System.out.println("result"+woodCollected(arr,k));
        /*char ch='A';
        char lower=(char)(ch+('a'-'A'));
        System.out.println("lower:  "+lower);*/

    }


    public static int woodCollected(int [] heights, int k){

        int maxHeight=0;//2
        for(int height:heights){
            maxHeight=Math.max(maxHeight,height);
        }
        int low=0;
        int ans=-1;

        while(low<=maxHeight){
            //int cuttingHeight= low+(maxHeight-low)/2;
            int cuttingHeight= (maxHeight+low)/2;
            int collectedWood=collectWod(heights,cuttingHeight);
            if(collectedWood==k){
                ans=cuttingHeight;
                return ans;
            }
            else if(collectedWood>k)
            {
                //low=  cuttingHeight+1;
                low=  cuttingHeight;//reduce total collect wood
            }
            else{
               // maxHeight=cuttingHeight-1;
                maxHeight=cuttingHeight;// increase totalwood cutting
            }
        }
        return ans;
    }

    private static int collectWod(int [] heights, int cuttingHeight){

        int colectWood=0;

        for(int height: heights){
            colectWood=colectWood+Math.max(0,height-cuttingHeight);
        }
        return colectWood;
    }
}
