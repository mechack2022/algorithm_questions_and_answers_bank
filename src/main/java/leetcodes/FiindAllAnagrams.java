package leetcodes;
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */


import java.util.*;

public class FiindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//
//        if (s.length() == 0 || p.length() == 0) {
//            return result;
//        }
//        for (int i = 0; i < s.length() - p.length(); i++) {
//          String subString = s.substring(i, i+ p.length() );
//          if(isAnagram(subString, p)){
//              result.add(i);
//          }
//        }
//        return result;
//    }
//
//    public static boolean isAnagram(String a, String b){
//        char[] charArrayA = a.toCharArray();
//        char[] charArrayB = b.toCharArray();
//        Arrays.sort(charArrayA);
//        Arrays.sort(charArrayB);
//        return Arrays.equals(charArrayA, charArrayB);
//    }
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

//        create a key and value pair form string p
        for (char c : p.toCharArray()) {
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) + 1);
            } else {
                pMap.put(c, 1);
            }
        }

        // create key and value pairs for string s
        for(int i =0; i<s.length(); i++ ){
            char currentCharacter = s.charAt(i);
            if (sMap.containsKey(currentCharacter)) {
                sMap.put(currentCharacter, pMap.get(currentCharacter) + 1);
            } else {
                sMap.put(currentCharacter, 1);
            }
//           if the index of the currentCharacter is greater than the length of p
            if(i >= p.length()){
              char removeChar = s.charAt(i - p.length());
              if(sMap.get(removeChar) == 1){
                  sMap.remove(removeChar);
              }else{
                  sMap.put(removeChar, sMap.get(removeChar) -1 );
              }

           }
//            compare the map objects of the two map
            if(pMap.equals(sMap)){
                result.add(i - p.length() + 1 );
            }
        }
        return result;
    }


}
