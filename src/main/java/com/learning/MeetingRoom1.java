package com.learning;

import java.util.Arrays;

public class MeetingRoom1 {
   // time Complexity: O(n log n) (s
    private boolean canAttendMeetings( int [][] interval)
    {
        //sort based on start date
        Arrays.sort(interval,(a, b)->a[0]-b[0]);

        for(int i=1;i<interval.length;i++)
        {
            //check second ka start date < befor end time tne overlap
            //interval[i] second [0]= start time
            //interval[i-1] first [1]=end time
            if(interval[i][0]<interval[i-1][1])
                return false;
        }
         return true;
    }

    public static void main(String[] args) {
       // Input: intervals = {{2, 6}, {7, 9}, {10, 14}, {15, 18}}
    }
}

