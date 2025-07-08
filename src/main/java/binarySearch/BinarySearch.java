package binarySearch;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BinarySearch {

    //
    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static int orderIgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];  // this return true of false depend on the passed in array

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid])  // mid value is thesame both.
                return mid;
            //check if array is sorted by checking the first element to the last element
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid++;
                }
            }
//        else if isAscending is false
            else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid++;
                }
            }
        }
        return -1;
    }

    /*Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x,
    and  Assume that the array is sorted in non-decreasing order.
    Write efficient functions to find the ceiling of x.
    Examples :
    For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
    For x = 0:     ceil  = 1
    For x = 1:     ceil  = 1
    For x = 5:     ceil  = 8
    For x = 20:    ceil doesn't exist in array*/
    public static int numCeiling(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        if (target < arr[0]) {
            return arr[0];
        } else if (target > arr[end]) {
            return -1;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    end = mid - 1;
                    if (arr[end] >= target && arr[mid-1] <= target) {
                        return arr[end];
                    }
                } else if (target > arr[mid]) {
                    start = mid + 1;
                    if (arr[start] >= target) {
                        return arr[start];
                    }
                } else
                    return arr[mid];
            }

        }
        return -1;
    }
    public static int shortNumCeilingMethod(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                return arr[mid];
        }
        return arr[start];
    }




//    public static int numFloor(int[] arr, int target){
//        int start= 0; int end = arr.length-1;
//        while (start <= end) {
//
//        }
//
//    }



    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 29, 65};
//        System.out.println(binarySearch(arr, 7));
//        System.out.println(binarySearch(new int[]{}, 65));

        int[] arr2 = {2, 39, 11, 5, 8, 54, 8, 78};
        int[] arr3 = {1, 2, 8, 10, 10, 12, 19};
//        System.out.println(binarySearch(arr2, 78));
//        System.out.println(orderIgnosticBS(arr2, 78));
        System.out.println(shortNumCeilingMethod(arr3, 13));
        String str = " Hello World ";
        Pattern pattern = Pattern.compile("\\s+");
        String str2 = " Hello World ";

        String[] words = pattern.split(str);
        String[] words2 = str.split(" " );
        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(words2));

    }


}
