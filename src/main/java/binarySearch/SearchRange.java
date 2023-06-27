package binarySearch;

import java.util.Arrays;

/*Given an array of integers nums sorted in ascending order, find the starting and the ending position
if target is not found return [-1,-1];
* of the given target  value
* example input : [5,7,7,8,8, 10]  output:[3,4]
* */
public class SearchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 8, 7, 8, 6, 8, 10, 11}, 8)));
    }

    public static int[] searchRange(int[] input, int target) {
        int[] ans = {-1, -1};
        int start = search(input, target, true);
        int end = search(input, target, false);

        ans[0] = start;
        ans[1] = end;
        return ans;
    }


    public static int search(int[] input, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < input[mid]) {
                end = mid - 1;
            } else if (target > input[mid]) {
                start = mid + 1;
            } else {
                // found potential asnswer
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return ans;
    }
}
