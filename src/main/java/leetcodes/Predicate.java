package leetcodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Predicate {


    public static void main(String[] args) {
        Predicate predicate = new Predicate();
        Integer[] arr = {5, 1, 3, 4, 2, 5, 1, 3, 4, 2, 2, 3};
        Integer[] unsortedArr ={5, 4, 7, 9, 1, 8, 2, 3, 6};
        Map<Integer, String> students = new HashMap<Integer, String>();
        students.put(1,"Lawrence");
        students.put(2,"Micheal");
        students.put(4,"Ben");
//        predicate.mapLooping(students);
//        System.out.println(arrayFrequency(arr));
//        System.out.println(arrayFrequency2(arr));
        System.out.println(findComplement(unsortedArr, 10));
    }

    public void mapLooping(Map<Integer, String> students) {
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("key : " + entry.getKey() + " value:  " + entry.getValue());
        }

    }

    public static  Map<Integer, Integer> arrayFrequency(Integer[] arr){

        Map<Integer, Integer>  map = new HashMap<>();
        for(Integer num : arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num) +1);
            }
            else{
                map.put(num, 1);
            }
        }
       return map;

    }


    //USING JAVA 8
    public static  Map<Integer, Long> arrayFrequency2(Integer[] arr){
        return Arrays
                       .stream(arr)
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    public static boolean findComplement(Integer[] arr, int target){
        Integer count = 1;
        Map<Integer, Integer>  map = new HashMap<>();
        for(Integer entry : arr){
            map.put(entry,count);
            count++;
        }

//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() +)
//        }

        System.out.println(map);
        return true;
    }

}
