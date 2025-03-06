package clientQuestion;

import java.util.Arrays;

public class MaximumMeetingInARoom {
    public static int maxMeetings(int start[], int end[], int n)
    {
        int intervals[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);

        int total=1, previousEndTime=intervals[0][1]; // end time
        for (int [] interval:intervals) {
            if (interval[0]>previousEndTime){//chek prev end is smaller then current start
                total++;
                previousEndTime=interval[1];//update pre end date
            }
        }

        return total;
    }
}
