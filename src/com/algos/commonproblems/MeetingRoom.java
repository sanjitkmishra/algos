package com.algos.commonproblems;

import java.util.*;

public class MeetingRoom {
    static class Interval
    {
        private int start;
        private int end;

        public Interval()
        {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public int maxMeetingRoom(Interval[] intervals)
    {
        if(intervals == null || intervals.length == 0)
        {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((a,b) -> a.end -b.end);
        priorityQueue.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++)
        {
            Interval earliest = priorityQueue.remove();
            Interval current = intervals[i];
            if(current.start >= earliest.end)
            {
                earliest.end = current.end;
            }
            else
            {
                priorityQueue.add(current);
            }
            priorityQueue.add(earliest);
        }
        return priorityQueue.size();
    }

    public static void main(String[] args)
    {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5,10);
        intervals[2] = new Interval(15,20);

        System.out.println( new MeetingRoom().maxMeetingRoom(intervals));
    }
}
