package leetcodes;

import java.util.Arrays;
import java.util.Iterator;

/*
Remove Duplicates from Sorted Array:
   - Statement: Given a sorted array `nums`, remove the duplicates in-place such that each element appears only once and returns the new length.
   - Example 1: Input: nums = [1, 1, 2], Output: 2 (modified array: [1, 2]).
   - Example 2: Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4], Output: 5 (modified array: [0, 1, 2, 3, 4]).

 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicate(new int[]{ 1, 1, 2}));
    }
    public static int removeDuplicate(int[] arr){
        int count = 1;
        if(arr.length == 0){
            return 0;
        }
        for(int currentIndex = 1; currentIndex < arr.length  ; currentIndex ++ ){
            if( arr[currentIndex] != arr[currentIndex - 1] ){
                arr[count] = arr[currentIndex];
                count++;
            }
        }

        return count;
    }
}
