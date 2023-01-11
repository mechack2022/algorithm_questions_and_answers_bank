package binarySearch;

public class BinarySearch2D {


    public static void main(String[] args) {
        int[][]  matrix = {
                {10,20,30,40},
                {15, 25, 35, 45},
                {28, 28, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println(search(matrix, 30));
    }
    public static int[] search(int[][] matrix, int target){
        int row = 0;  // where start is row
        int col = matrix.length - 1;  // where end is the last column

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row, col};
            }
            else if(matrix[row][col] < target){
                row--;
            }
            else if(matrix[row][col] > target){
                row++;
            }
        }
        return new int[]{row, col};
    }
}
