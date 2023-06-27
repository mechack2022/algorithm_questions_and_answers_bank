package LinearSearch;

public class LinearSearch {

    public static void main(String[] args) {
        int[] numbers = {39, 2, 1, 24, 76, 9};
//        System.out.println(findMinElement(numbers));

        int target = 76;
//        System.out.println(linearSearch(numbers, target));
        String name = "linear";
        char tar = 'r';
//        System.out.println(stringLinearSearchInRange(name, 2, 5, 'a'));
//        System.out.println(stirngLinearSearch(name, tar));

        int[][] arr = {{2, 4, 8, 9},
                {91, 64, 83, 2, 9}, {94, 42, 20}};
        int[] ans = twoDLinearSearch(arr, 4);
//        System.out.println(Arrays.toString(ans));
        System.out.println(twoDLinearSearch2(arr, 9));
//        System.out.println(twoDLinearSearch2Max(arr));
        int[] nums = {1, 9, 1, 8, 123, 1, 3462};
//        System.out.println(findEvenDIgit(nums));
//        System.out.println(countDigit2(-123336));


    }

    public static int linearSearch(int[] nums, int num) {
        if (nums.length == 0) return -1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == num) return index;
        }
        return -1;
    }

    public static boolean stringLinearSearchInRange(String str, int start, int end, char target) {
        if (str.length() == 0 || start > end || end > str.length()) {
            return false;
        }
        char[] tempArray = str.toCharArray();
        for (int index = start; index <= end; index++) {
//            check for character at every index if it equals target
            char ch = tempArray[index];
            if (ch == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean stringLinearSearch(String str, char target) {
        if (str.length() == 0) return false;
        for (char ch : str.toCharArray()) {
            if (ch == target)
                return true;
        }
        return false;
    }

    public static int findMinElement(int[] numbers) {
        int min = numbers[0];
        for (int el : numbers) {
            if (min < el) {
                return min;
            }
            min = el;
        }
        return min;
    }

    //    this method will return the position of the the target
    public static int[] twoDLinearSearch(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }

            }
        }
        return new int[]{-1, -1};
    }

    //    this method will return the value of the target
    public static int twoDLinearSearch2(int[][] arr, int target) {
        int targetValue;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                targetValue = arr[row][col];
                if (targetValue == target) {
                    return targetValue;
                }
            }
        }
        return -1;
    }

    public static int twoDLinearSearch2Max(int[][] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > maxValue) {
                    maxValue = anInt;
                }
            }
        }
        return maxValue;
    }

    //    Given an array of numbers   of integers, returns how many of them contains an even number of digits.digits
//    e.g [18,9, 124, 98, 123,1, 3462] output is 3
    public static int findEvenDIgit(int[] arr) {
        if (arr.length == 0) return -1;
        int count = 0;
        for (int el : arr) {
            String s = el + "";
            if (s.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countDIgitsinNumber(int num) {
//        check for negative numbers  and covert to positive numbers
        int count = 0;
        if (num < 0)
            num = num * -1;

        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    public static int countDigit2(int nums) {
        if(nums < 0)
            nums = nums * -1;
        return (int) (Math.log10(nums)) + 1;
    }

//    for binary counting
// public static int countBinary(int nums) {
//        return (int)log2(nums)) + 1;
// }


}
