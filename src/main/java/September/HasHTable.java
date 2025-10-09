package September;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HasHTable {

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Example 1: " + Arrays.toString(result1)); // [0, 1]

        // Test Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Example 2: " + Arrays.toString(result2)); // [1, 2]

        // Additional test cases
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Example 3: " + Arrays.toString(result3)); // [0, 1]

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                // found
                return new int[]{map.get(complement), i};

            }

            map.put(i, nums[i]);

        }

        return new int[]{};
    }


}
