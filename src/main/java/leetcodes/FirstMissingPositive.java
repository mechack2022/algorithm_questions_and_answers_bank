package leetcodes;

import java.util.*;

/*
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */
public class FirstMissingPositive {
    static int[] arr = {3,4,-1,1};

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
//        int result = 0;
//        List<Integer> positiveInt = new ArrayList<>();
//        if (arr.length == 0) {
//            return result;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= 1) {
//                positiveInt.add(arr[i]);
//            }
//            Collections.sort(positiveInt);
//            System.out.println(positiveInt);
//        }
//        if (positiveInt.get(0) != 1) {
//            return 1;
//        } else {
//            for (int i = 0; i < positiveInt.size(); i++) {
//
//            }
//        }
//
//        return 0;
//    }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
             while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
