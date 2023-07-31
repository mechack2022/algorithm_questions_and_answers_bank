package codewars;
/*
The main idea is to count all the occurring characters in a string.
If you have a string like aba, then the result should be {'a': 2, 'b': 1}.

What if the string is empty? Then the result should be empty object literal, {}.


 */

import java.util.HashMap;
import java.util.Map;

public class CountKata {
    public static void main(String[] args) {
        String str = "abaaccbb";
        System.out.println(count(str));
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> result = new HashMap<>();
        if (str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (result.containsKey(chars[i])) {
                int count = result.get(chars[i]);
                result.put(chars[i], count + 1);
            }else {
                result.put(chars[i], 1);
            }
        }
        return result;
    }
}