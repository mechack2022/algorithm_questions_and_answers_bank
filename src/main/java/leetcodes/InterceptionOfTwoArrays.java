package leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
public class InterceptionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] num3 = {4, 9, 5};
        int[] num4 = {9, 4, 9, 8, 4};

        System.out.println((Arrays.toString(interceptionOfTwoArrays(num1, num2))));
        System.out.println((Arrays.toString(interceptionOfTwoArrays(num3, num4))));
    }

    public static int[] interceptionOfTwoArrays(int[] num1, int[] num2) {
        if (num1.length == 0) {
            return new int[0];
        }
        HashSet<Integer> result = new HashSet<>();
        for (int k : num1) {
            for (int i : num2) {
                if (k == i) {
                    result.add(k);
                }
            }
        }
        // Convert the HashSet to an array of integers
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int num : result) {
            resultArray[index++] = num;
        }
        return resultArray;
    }
}
