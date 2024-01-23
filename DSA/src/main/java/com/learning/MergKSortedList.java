package com.learning;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergKSortedList {
//https://www.youtube.com/watch?v=E5WSILx1q0Q youtube link
/*The overall time complexity is O(n log k), where n is the total number of elements, and k is the number of lists.
    The overall space complexity is O(k), considering the space used by the priority*/
    public static ArrayList<Integer> mergedKList(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.value- b.value);
        for (int i = 0; i < lists.size(); i++)// add first element from each list into queue;
        {
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
        }
        while (!pq.isEmpty()) {
            Pair temp = pq.remove();
            result.add(temp.value);
            temp.dataIndex++;// increment  for next index data in same list
            if (temp.dataIndex < lists.get(temp.listIndex).size()) {// check list have more data if present then add
                temp.value = lists.get(temp.listIndex).get(temp.dataIndex);
                pq.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        lists.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        lists.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(23);
        list3.add(24);
        list3.add(25);
        lists.add(list3);
        ArrayList<Integer> result = mergedKList(lists);

        for (Integer data : result) {
            System.out.print(data + " ,");
        }

    }
}

class Pair {
    int listIndex;//store list index example 1st list 2nd list
    int dataIndex;//stor data index for paerticular inde;
    int value;

    Pair(int li, int di, int val) {
        this.listIndex = li;
        this.dataIndex = di;
        this.value = val;

    }
}


