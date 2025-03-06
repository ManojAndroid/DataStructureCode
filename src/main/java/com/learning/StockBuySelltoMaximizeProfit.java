package com.learning;

import java.util.ArrayList;
import java.util.List;

public class StockBuySelltoMaximizeProfit {

    static int maxProfit(int[] prices, int n) {

        if (n == 1)
            return 0;
        List<Interval> sol = new ArrayList<>();
        int count = 0;

        int i = 0;
        while ((i < n)) {

            while (i < n - 1 && prices[i + 1] <= prices[i])
                i++;

            if (i == n - 1)
                break;
            Interval interval = new Interval();

            interval.buy = i++;

            while (i < n && prices[i - 1] < prices[i])
                i++;

            interval.sell = i - 1;
            sol.add(interval);
            count++;
        }
        int totalSum=0;

        for (Interval  val: sol)
        {
            System.out.println("buy day"+ val.buy +"sell day"+ val.sell);
            totalSum=totalSum+prices[val.sell]-prices[val.buy];
        }
       return totalSum;

    }
    //O(n)
    private static  int maxForSingleDay(int [] prices){
            int minPrice=prices[0];
            int maxProfit=0;
            for(int i=1;i<prices.length;i++)
            {
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
                minPrice=Math.min(minPrice,prices[i]);
            }
            return maxProfit;

    }
    //O(n)
    public static int maxProfit(int [] prices){
        int profit = 0;
        int buy = prices[0];
        int days = prices.length;
        for (int i = 1; i < days; i++) {
            if (buy < prices[i])
                profit += prices[i] - buy;
            buy = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(arr, arr.length));
        System.out.println("max profit for single day");
        int ar1[] = {7,1,5,3,6,4};
        //Output: 5
        System.out.println(maxForSingleDay(ar1));
    }
}

class Interval {
    int buy, sell;
}
