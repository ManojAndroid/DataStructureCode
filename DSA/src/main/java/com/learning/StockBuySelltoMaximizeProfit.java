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

    public static void main(String[] args) {
        int arr[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(arr, arr.length));
    }
}

class Interval {
    int buy, sell;
}
