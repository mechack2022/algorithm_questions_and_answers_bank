package leetcodes;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, a
nd return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println((Arrays.deepToString(mergeInterval(intervals))));
    }

    public static int[][] mergeInterval(int[][] arr) {
        if (arr.length == 0 || arr == null) {
            return new int[0][];
        }
        // sor the arrays
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();
        int[] currentElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
//            check if the second item in the currentArray is greater than or equal the
            if (currentElement[1] >= arr[i][0]) {
                currentElement[1] =Math.max(arr[i][1], currentElement[1]);
            } else {
                result.add(currentElement);
                currentElement = arr[i];
            }
        }
        result.add(currentElement);
        return result.toArray(new int[result.size()][]);
    }
}
