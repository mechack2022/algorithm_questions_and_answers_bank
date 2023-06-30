/*
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>(Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        ));
        System.out.println(mergeInterval(list));
    }

    // an object thar has two values end and start
    private static class Interval {
        int start = 0;
        int end = 0;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
//        sort the intervals by using self define comparator
        Collections.sort(intervals, new CompareInterval());

        ArrayList<Interval> result = new ArrayList<>();

        Interval prevItem = intervals.get(0);

        for (int i = 0; i < intervals.size(); i++) {
            Interval currItem = intervals.get(i);
            if (prevItem.end >= currItem.start) {
                // create a new interval with the start is the start of the prevItem and the end is the max between the two
                Interval newInterval = new Interval(prevItem.start, Math.max(prevItem.end, currItem.end));
                prevItem = newInterval;

            } else {
                result.add(prevItem);
                prevItem = currItem;
            }
        }
        result.add(prevItem);
        return result;
    }


    //    this class compare the each object of the list, by checking the first element in the object
    public static class CompareInterval implements Comparator<Interval> {
        @Override
        public int compare(Interval obj1, Interval obj2) {
            return obj1.start - obj2.start;
        }
    }

}
