package leetcodes;

/*
Spiral Matrix:
   - Problem Statement: Given an m x n matrix, return all elements of the matrix in spiral order.
   - Example 1:
     - Input:
       ```
       matrix = [
         [1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]
       ]
       ```
     - Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
   - Example 2:
     - Input:
       ```
       matrix = [
         [1, 2, 3, 4],
         [5, 6, 7, 8],
         [9, 10, 11, 12]
       ]
       ```
     - Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

 */

import java.util.ArrayList;
import java.util.List;


public class Matrix {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse left
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                // Traverse up
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return result;
    }


}
