package string;

/*
    Given a string S, find the longest palindromic substring in S.
    Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string:
    A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
    Incase of conflict, return the substring which occurs first ( with the least starting index).

    Example 1:
    Input:
    S = "aaaabbaa"
    Output: aabbaa
    Explanation: The longest Palindromic
    substring is "aabbaa".
    Example 2:

    Input:
    S = "abc"
    Output: a
    Explanation: "a", "b" and "c" are the
    longest palindromes with same length.
    The result is the one with the least
    starting index.

*/

import java.util.stream.IntStream;

public class LongestPalindrome {

    public static void main(String args[]) {
        System.out.println(longestPalin("aaabbaa"));
        System.out.println(longestPalin("abc"));
        System.out.println(isPalindromic("abc"));
    }

    static String longestPalin(String str) {
        String longestPalin = "";

        // Loop through all substrings of S and check if they are palindromic
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substr = str.substring(i, j);
//                If the current substring is palindromic
                if (isPalindromic(substr)) {
//                    If the current is longer than the longest one found so far, update longestPalin
                    if (substr.length() > longestPalin.length())
                        longestPalin = substr;
                }
            }
        }
        return longestPalin;
    }

    private static boolean isPalindromic(String substr) {
        StringBuilder sb = new StringBuilder(substr);
        String strReverse = sb.reverse().toString();
        if (strReverse.equals(substr)) {
            return true;
        }
        return false;

    }


    public static String method2(String S){

        String longestPalin = "";
        int n = S.length();
        // Start with the longest possible substrings and work our way down
        for (int len = n; len > 0; len--) {
            // Check all substrings of length len
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Index of last character in substring
                if (isPalindromic(S, i, j)) {
                    longestPalin = S.substring(i, j + 1);
                    break; // No need to check shorter substrings
                }
            }
            if (!longestPalin.isEmpty()) {
                break; // Found the longest palindromic substring
            }
        }

        return longestPalin;
    }

    // Check if a substring is palindromic using indices
    public static boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

