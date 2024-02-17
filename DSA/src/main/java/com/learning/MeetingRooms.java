package com.learning;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    //https://www.youtube.com/watch?v=NKf1OJhEZj0
    //Time complexity (nlongn)
    public static int minMeetingRooms(TimeInterval[] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);//sort

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i].end);
        }

        return pq.size();

    }

    public static void main(String[] args) {
        TimeInterval[] intervals = {
                new TimeInterval(0, 30),
                new TimeInterval(0, 2),
                new TimeInterval(5, 10),
                new TimeInterval(7, 22),
                new TimeInterval(15, 20)
        };

        int minRooms = minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms required: " + minRooms);
    }
}

class TimeInterval {
    int start;
    int end;

    public TimeInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
