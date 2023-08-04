package leetcodes;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchRange {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10,8};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }
    public static int[] searchRange(int[] arr, int target) {
        int[] result = new int[2];

        int startPos = -1;
        int endPos = -1;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                if (startPos == -1) {
                    startPos = i;
                }
                endPos = i;
            }
        }

        result[0] = startPos;
        result[1] = endPos;

        return result;
    }
}
