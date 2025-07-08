package leetcodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*The problem:
Given two words (start and end), and a dictionary, find the length of shortest trans-
formation sequence from start to end, such that:
Only one letter can be changed at a time Each intermediate word must exist in the
dictionary For example, Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program should return its length 5.
Note: Return 0 if there is no such transformation sequence. All words have the same length. All words contain
only lowercase alphabetic characters.*/
public class LadderLength {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] arr = new String[]{"hot", "dot", "dog", "lot", "log"};
        HashSet<String> dict = (HashSet<String>) Arrays.stream(arr).collect(Collectors.toSet());


        System.out.println(ladderLength(start, end, dict));
    }

    public static int ladderLength(String start, String end, HashSet<String> dict) {
        boolean pass = false;
        int count = 0;
        String currentWord = null;
        if(start.length() != end.length()){
            return  -1;
        }

        for(String str : dict){
            if(start.length() == str.length()){

            }
        }
        System.out.println(dict);
        return 1;
    }
}
