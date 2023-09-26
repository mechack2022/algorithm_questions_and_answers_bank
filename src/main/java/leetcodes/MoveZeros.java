package leetcodes;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

 */

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));

    }

    public static int[] moveZeros(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
//        get all non-zero values and add to the list
        for (int num : arr) {
            if (num != 0) {
                result.add(num);
            }
        }
//        get all zero values and add to the list
        for (int num : arr) {
            if (num == 0) {
                result.add(num);
            }
        }

        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }



}
