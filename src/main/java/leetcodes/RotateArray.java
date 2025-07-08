package leetcodes;

import java.util.Arrays;

/*
Problem:
Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3,
the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].Input:
Array: [4, 7, 2, 9, 1]
Steps: 2

Output:
Rotated Array: [9, 1, 4, 7, 2]

Input:
Array: [6, 8, 2, 5, 3, 1, 9, 7]
Steps: 5

Output:
Rotated Array: [5, 3, 1, 9, 7, 6, 8, 2]

*/
public class RotateArray {


    public static void main(String[] args) {
        int[] arr = {6, 8, 2, 5, 3, 1, 9, 7};
        int[] arr2 = {1, 9, 5, 4, 5, 6, 7, 17};
        int k = 5;

        RotateArray rotateArray = new RotateArray();
        int[] result = rotateArray.rotateArray(arr, k);
        System.out.println(Arrays.toString(result));

    }

    public int[] rotateArray(int[] arr, int k) {
        int[] result = new int[arr.length];
//        if k is greater than the arr length, reduce it to arr length range
        if (k > arr.length) {
            k = k % arr.length; //  if arr length = 5, and k = 7; the reduce k = 7 % 5
        }

        for (int i = 0; i < k; i++) {
            result[i] = arr[arr.length - k + i];  // result[0] = arr[7 -3 + 0] = arr[4] = 5, assuming the array is [1,2,3,4,5,6,7]
        }
        int j = 0;
        for (int i = k; i < arr.length; i++) {
            result[i] = arr[j];    // result [3] = arr[0]= 1, it iterate  till i = 6
            j++;
        }

        return result;
    }


    //    using java 8
    public int[] rotateArray2(int[] arr, int k) {
        int[] result = new int[arr.length];
        if (k > arr.length) {
            k = k % arr.length;
        }

        int[] rotatedSuffix = Arrays.stream(arr, arr.length - k, arr.length).toArray();
        int[] rotatedPrefix = Arrays.stream(arr, 0, arr.length - k).toArray();

        System.arraycopy(rotatedSuffix, 0, result, 0, rotatedSuffix.length);
        System.arraycopy(rotatedPrefix, 0, result, rotatedSuffix.length, rotatedPrefix.length);

        return result;
    }


}
