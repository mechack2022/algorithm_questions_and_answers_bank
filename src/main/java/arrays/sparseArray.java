package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *There is a collection of input strings and a collection of query strings. For each query string,
 * determine how many times it occurs in the list of input strings. Return an array of the results.
 * input
 * StringList = {"aba", "baba", "aba", "xzxb"}
 * queries ={"aba", "xzxb", "ab"}
 * output
 * {2,1,0}
 * In this example, the matchingStrings() method is called with stringList containing four strings
 * and queries containing three strings. The method returns a list of integers representing the number
 * of times each query string appears in the stringList.
 * */
public class sparseArray {


    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("ba", "xzxb", "ab");

        System.out.println(matchingStrings(stringList, queries));
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> result = new ArrayList<>();

        queries.forEach(str -> {
            long count = stringList.stream().filter(el -> el.equals(str)).count();
            result.add((int) count);
        });
        return result;
    }

}
