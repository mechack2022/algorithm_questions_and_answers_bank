package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
Two Sum:
Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
Example: Input: nums = [2, 7, 11, 15], target = 9. Output: [0, 1].*/
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum4(new int[]{ 2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] arr, Integer target) {
        int firstIndex = -1;
        int secondIndex = -1;

        int[] result = new int[2];

        result[0] = firstIndex;
        result[1] = secondIndex;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //    using while loop for thesame questions
    public static int[] twoSum2(int[] arr, int target) {
        int firstIndex = -1;
        int secondIndex = -1;

        int[] result = new int[2];
        result[0] = firstIndex;
        result[1] = secondIndex;

        int i = 0;
        while (i < arr.length - 1) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
                j++;
            }
            i++;
        }

        return result;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return true;
                    }
                    map.put(nums[i], i);
                    return false;
                })
                .mapToObj(i -> new int[]{map.get(target - nums[i]), i})
                .findFirst()
                .orElse(new int[0]);
    }

    public  static int[] twoSum4(int[] nums, int target){

        for(int i =0; i < nums.length; i++){
            for(int j =i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }



}

