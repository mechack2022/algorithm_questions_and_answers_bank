package leetcodes;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] num2 = {2,0,1};
        System.out.println(Arrays.toString(sortColors(num2)));
    }

    public static int[] sortColors(int[] colors){
        List<Integer> sortedColorsList= Arrays.stream(colors).sorted().boxed().toList();
        int[] result = new int[sortedColorsList.size()];
        int resultIndex =0;
        for(int i= 0; i<sortedColorsList.size(); i++){
            result[resultIndex] = sortedColorsList.get(i);
            resultIndex++;
        }
        System.out.println(sortedColorsList);
        return result;
    }



}
