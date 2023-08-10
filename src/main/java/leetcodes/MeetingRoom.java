package leetcodes;

import java.util.*;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example:
Input: intervals = [[7,10],[2,4]]
Output: true

 */
public class MeetingRoom {
    public static void main(String[] args) {
        ArrayList<MeetingInterval> list = new ArrayList<>(Arrays.asList(
                new MeetingInterval(0, 30),
                new MeetingInterval(5, 10),
                new MeetingInterval(15, 20)
        ));

        System.out.println(meetingRoom(list));
    }

    public static Boolean meetingRoom(ArrayList<MeetingInterval> meetIntervals) {
        if (meetIntervals == null || meetIntervals.size() <= 1) {
            return true;
        }
        meetIntervals.sort(new ComparaInterval());
        System.out.println(meetIntervals);

        for (int i = 1; i < meetIntervals.size(); i++) {
            MeetingInterval currentInterval = meetIntervals.get(i-1);
            MeetingInterval nextInterval = meetIntervals.get(i);
            if (currentInterval.endTime >= nextInterval.startTime) {
                System.out.println("prv meeting endtime " + currentInterval.endTime + " next meeting start time " + meetIntervals.get(i).startTime);
                return false;
            }
        }
        return true;
    }

    private static class MeetingInterval {
        private int startTime;
        private int endTime;
        public MeetingInterval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "{ " + startTime + ", " + endTime + " }";
        }
    }

    private static class ComparaInterval implements Comparator<MeetingInterval> {
        @Override
        public int compare(MeetingInterval obj1, MeetingInterval obj2) {
            return obj1.startTime - obj2.startTime;
        }
    }
}
