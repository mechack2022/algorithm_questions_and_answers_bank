package geeksforgeeks;

import java.util.*;

public class GeeksForQestionsImp implements GeekForGeeksQuestions {

    /*
    Input: N = 5, S = 12
    A[] = {1,2,3,7,5}
    Output: 2 4
   Explanation: The sum of elements
   from 2nd position to 4th position
     is 12.
*/
    @Override
    public ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        var sum = 0;
        var right = 0;
        var left = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (right < n) {
            sum += arr[right++];

            while (sum > s) {
                sum -= arr[left++];
            }
            if (sum == s) {
                result.add(left + 1);
                result.add(right);
                System.out.println(result);
                return result;
            }
        }
        result.add(-1);
        return result;
    }


    static ArrayList<Integer> subarraySum2(int[] arr, int n, int s)
    {
        // Your code here
        int sum = 0;
        int right = 0;
        int left = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (right < n) {
            sum += arr[right];

            while (sum > s) {
                sum -= arr[left];
                left++;
            }

            if (sum == s) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
            right++;
        }
        result.add(-1);
        return result;
    }


    /*
    Input:
    N = 5
    A[] = {1,2,3,5}
    Output: 4
    Example 2:

    Input:
    N = 10
    A[] = {6,1,2,8,3,4,7,10,5}
    Output: 9
*/
    @Override
    public int MissingNumber(int[] array, int n) {
      int actualSum = 0;
      int  expectedSum = 0;
      for(Integer num : array){
           actualSum += num;
      }
    for(int i=1; i <= n; i++){
        expectedSum += i;

    }
        System.out.println(expectedSum- actualSum);
       return expectedSum - actualSum;
    }


//    SHOP




}


