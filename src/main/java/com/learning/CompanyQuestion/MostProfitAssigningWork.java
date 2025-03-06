package com.learning.CompanyQuestion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostProfitAssigningWork {

  /*  would like to discuss the runtime complexity:
    the 1st for loop: O(JlogJ)
  2nd : O(J)
  3rd : O(WlogJ)
    so the total: O(JlogJ)+O(WlogJ)*/
  static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    TreeMap<Integer, Integer> tmap = new TreeMap<>();
    // in case two jobs have same difficulty but different profit, we want to count
    // the higher profit
    for (int i = 0; i < difficulty.length; i++) {
      tmap.put(difficulty[i], Math.max(profit[i], tmap.getOrDefault(difficulty[i], 0)));
    }

    int max = 0, res = 0;
    // maximum profit at this difficulty or below in case
    // lower difficulty job offers higher profit
    for (Integer key : tmap.keySet()) {
      max = Math.max(tmap.get(key), max);
      tmap.put(key, max);
    }
    for (int i = 0; i < worker.length; i++) {
      Integer key = tmap.floorKey(worker[i]);
      if (key != null) {
        res += tmap.get(key);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] difficulty = {2, 4, 6, 8, 10};
    int[] profit = {10, 20, 30, 40, 50};
    int[] worker = {4, 5, 6, 7};
    int value = maxProfitAssignment(difficulty, profit, worker);
    System.out.println("value :" + value);
  }
}
