package binarySearch;


/*Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x,
    and  Assume that the array is sorted in non-decreasing order.
    Write efficient functions to find the ceiling of x.
    Examples :
    For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
    For x = 0:     ceil  = 1
    For x = 1:     ceil  = 1
    For x = 5:     ceil  = 8
    For x = 20:    ceil doesn't exist in array*/
public class CeilingUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println(ceilingUsingBinarySearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
        System.out.println(floorUsingBinarySearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
    }

    public static int ceilingUsingBinarySearch(int[] arr, int target){
       if(target > arr[arr.length-1]){
           return -1;
       }
      int start= 0;
      int end= arr.length -1;
      while(start <= end){
          int mid = start + (end - start)/2;
           if(target > arr[mid]){
              start = mid+1;
          }
          else if(target < arr[mid]){
             end = mid  - 1;
          }
          else return arr[mid];
      }
      return arr[start];
    }

    public static int floorUsingBinarySearch(int[] arr, int target){
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start= 0;
        int end= arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > arr[mid]){
                start = mid+1;
            }
            else if(target < arr[mid]){
                end = mid  - 1;
            }
            else return arr[mid];
        }
        return arr[end];
    }

}
