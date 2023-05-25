package leetcodes;

/*
Finding the longest palindromic substring is a classic problem of coding interview
**/
public class LongestPalindrome {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babba"));
    }

    public static String longestPalindrome(String str){ // assuming str babba
         int maxPalindromeLength = 0;
         String longestPlalindrome = null;
        for(int i =0; i<str.length(); i++){
            for(int j =i+1; j<str.length(); j++){
                int len = j-i;
                String currentSubString = str.substring(i, j+1);
                if(isPalindrome(currentSubString)){
                    if(len > maxPalindromeLength){
                        longestPlalindrome = currentSubString;
                         maxPalindromeLength = len;
                    }

                }
            }
        }
        return longestPlalindrome;

    }

   static boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        String  reverseSb = sb.reverse().toString();
        if(reverseSb.equals(str)){
            return true;
        }
        return false;
    }


}
