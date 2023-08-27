package testing;

import java.util.Arrays;

public class AlgorithmTesting {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(productExceptItself2(new int[]{1, 2, 3, 4})));
//        System.out.println(Arrays.toString(productExceptItself2(new int[]{-1, 1, 0, -3, 3})));
//        System.out.println(bestTimeToBuyStock(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(bestTimeToBuyStock(new int[]{7, 6, 4, 3, 1}));

        System.out.println(highestString(new String[]{"Tayo", "hhetetehhhshhhh", "Tolui", "Racheak"}));
    }


    public static int[] productExceptItself(int[] arr) {
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//        Example 2:
//
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]

        int n = arr.length;
        int[] result = new int[n];
        int product = 1;
        int countZero = 0;

//        get the product of non zeros value
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                product *= arr[i];
            } else {
                countZero++;
            }
        }
//        check if count zero is greater than 1
        if (countZero > 1) {
            return result;
        }

        if (countZero == 1) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    result[i] = product;
                    break;
                }
            }
            return result;
        }

        for (int i = 0; i < n; i++) {
            result[i] = product / arr[i];
        }

        return result;
    }


    public static int[] productExceptItself2(int[] arr) {
        int n = arr.length;
        int[] resutt = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * arr[i - 1];
        }

        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            resutt[i] = rightProduct[i] * leftProduct[i];
        }
        return resutt;
    }

    //    BUY AND SELL
    public static int bestTimeToBuyStock(int[] stockPrices) {
//        - Example 1: Input: prices = [7, 1, 5, 3, 6, 4], Output: 5 (buy at day 2 and sell at day 5).
//        - Example 2: Input: prices = [7, 6, 4, 3, 1], Output: 0 (no transactions are possible, so the maximum profit is 0).

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : stockPrices) {
            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, price);

            // Update the maximum profit if the current price provides a better selling opportunity
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    public static String highestString(String[] arr) {
        String result = null;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxCount) {
                maxCount = arr[i].length();
                result = arr[i];
            }
        }
        return result;
    }



    /*
    3. Container With Most Water:
   - Statement: Given `n` non-negative integers `height` representing the heights of vertical lines,
    find two lines that together with the x-axis forms a container that contains the most water.
   - Example 1: Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7], Output: 49 (between the 8th and 9th elements).
   - Example 2: Input: height = [4, 3, 2, 1, 4], Output: 16 (between the 1st and 4th elements).


     */
}
