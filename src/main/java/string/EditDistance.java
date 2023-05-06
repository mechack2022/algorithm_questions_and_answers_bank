package string;
/*
Given two strings s and t. Return the minimum number of operations required to convert s to t.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.


Example 1:

Input:
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required
inserting 's' between two 'e's of s.
Example 2:

Input :
s = "gfg", t = "gfg"
Output:
0
Explanation: Both strings are same.

*/
public class EditDistance {

    public static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println(editDistance("geek", "gesek" ));
        System.out.println(editDistance("gfk", "gfk" ));
    }
}
//Explanation
/*We use dynamic programming to solve this problem. We create a 2D array dp where dp[i][j] represents
the minimum number of operations required to convert the first i characters of string s to the first j characters of string t.

The base cases are when either string is empty. In this case, the minimum number of operations required is the length of the other string.

For other cases, we have three choices:

If the i-th and j-th characters of s and t are the same, we don't need to do anything and we can use the solution for
the first i-1 characters of s and the first j-1 characters of t.

If the characters are different, we have three choices: we can either insert a character into s,
delete a character from s, or replace a character in s with a character from t. We take the minimum of these three choices and add one to get the minimum number of operations required.

After filling the entire dp table, the answer will be in dp[m][n], where m and n are the lengths of s and t, respectively.

In the example above, the output will be 1, because we can insert an 's' between the two 'e's in s to get t.*/