package leetcodes;
/*
Problem Statement:
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example:
Input: s = "leetcode"
Output: 0

Example:
Input: s = "loveleetcode"
Output: 2

 */

import java.util.Arrays;

public class FindUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(findUniqueCharacter("loveleetcode"));
    }

    private static int findUniqueCharacter(String str) {
        if(str.length() <= 2){
            return 0;
        }
        int count = 0;
        //convert String to arrays of characters
        char[] charArray = str.toCharArray();
        for(int i = 0; i<charArray.length; i++){
            for(int j = i+1; j<charArray.length; j++){
                char currentChar = charArray[i];
                char nextChar = charArray[j];
                System.out.println(" curr "+currentChar + " next "+ nextChar);
            }
        }
        return -1;
    }
}
