package leetcodes;

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder result = new StringBuilder();

        for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
            char currentChar = strs[0].charAt(charIndex);

            for (int i = 1; i < strs.length; i++) {
                if (charIndex >= strs[i].length() || strs[i].charAt(charIndex) != currentChar) {
                    return result.toString();
                }
            }
            result.append(currentChar);
        }

        return result.toString();
    }
}
