package leetcodes;
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductExceptItself {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptItself(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptItself(new int[]{-1, 1, 0, -3, 3})));

        System.out.println(Arrays.toString(method2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(method2(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptItself(int[] input) {
        int n = input.length;
        int[] output = new int[n];

        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * input[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * input[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }
        return output;
    }

    public static int[] method2(int[] input) {
        int n = input.length;
        int[] result = new int[n];
        int product = 1;
        int zeroCount = 0;

//       get the product of non-negative values
        for (int j : input) {
            if (j != 0) {
                product *= j;
            } else {
                zeroCount++;
            }
        }
//          check if zero count is more than 1, the result would be an arrays of zeros
        if (zeroCount > 1) {
            return result;
        }
//            if zeroCount is 1, the result[i] of the input index(where tge zero is)  is the product
        if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (input[i] == 0) {
                    result[i] = product;
                    break;
                }
            }
            return result;
        }
//            if there is no zero, Otherwise, calculate the result normally
        for (int i = 0; i < n; i++) {
            result[i] = product / input[i];
        }
        return result;
    }
}
