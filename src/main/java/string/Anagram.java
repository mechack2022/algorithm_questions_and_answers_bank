package string;

import java.util.Arrays;

/* find out if two strings are anagram , two strings are anagram if there conatins similar group of characters
*  a varies sequence
* example is fried  and fired, sor and ros, snow and rats and star */
public class Anagram {

    public static void main(String[] args) {
        System.out.println(anagram("fired", "fried"));
        System.out.println(anagram("fires", "fried"));
    }

    public static boolean anagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        char[] strA  = a.toCharArray();
        char[] strB = b.toCharArray();
          Arrays.sort(strA);
         Arrays.sort(strB);
//         compare each element in the same index
        for (int i = 0; i < strA.length; i++) {
            if (strA[i] == strB[i]) {
                return true;
            }
        }
        return false;
    }
}
