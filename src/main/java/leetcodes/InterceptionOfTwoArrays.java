package leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
public class InterceptionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] num3 ={4,9,5};
        int[] num4 = {9,4,9,8,4};

        System.out.println((interceptionOfTwoArrays(num1, num2)));
        System.out.println((interceptionOfTwoArrays(num3, num4)));
    }
    public static HashSet<Integer> interceptionOfTwoArrays(int[] num1, int[] num2){
      if(  num1.length ==  0){
          return new HashSet<>();
      }
      int count = 0;
      HashSet<Integer> result = new HashSet<>();
      for(int i = 0; i < num1.length; i++){
          for(int j = 0; j < num2.length; j++){
//              System.out.println("i = " + num1[i] + " j = " + num2[j]);
              if(num1[i] == num2[j] ){
                  result.add(num1[i]);
              }
          }
      }
      return result;
    }
}
