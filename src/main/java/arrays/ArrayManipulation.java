package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Starting with a 1-indexed array of zeros and a list of operations,
for each operation add a value to each the array element between two given indices,
inclusive. Once all operations have been performed, return the maximum value in the array.

Example
n=10
queries = {{1,5,3},{4,8,7},{6,9,1}}
the queries can be interpreted as
a b k
1 5 3
4 8 7
6 9 1

Add the values of k between the indices a and b  inclusive:
index->	 1 2 3  4  5 6 7 8 9 10
	    [0,0,0, 0, 0,0,0,0,0, 0]
	    [3,3,3, 3, 3,0,0,0,0, 0]
	    [3,3,3,10,10,7,7,7,0, 0]
	    [3,3,3,10,10,8,8,8,1, 0]

largest value will be 10 after all operation;
*/
public class ArrayManipulation {
    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> queries = new ArrayList<>() {{
            add(Arrays.asList(1, 5, 3));
            add(Arrays.asList(4, 8, 7));
            add(Arrays.asList(6, 9, 1));
        }};

        System.out.println(arrayManipulation(n, queries));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        long maxVal = Long.MIN_VALUE;

        // apply all the queries on the array using lambda expression
        queries.forEach(query -> {
            int startIndex = query.get(0) - 1;
            int endIndex = query.get(1) - 1;
            int value = query.get(2);

            arr[startIndex] += value;
            if (endIndex < n - 1) {
                arr[endIndex + 1] -= value;
            }
        });
        System.out.println(Arrays.toString(arr));

        // calculate the cumulative sum and track the maximum value
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum > maxVal) {
                maxVal = currentSum;
            }
        }
        System.out.println(Arrays.toString(arr));
        return maxVal;
    }


}