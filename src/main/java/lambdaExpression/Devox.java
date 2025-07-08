package lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//public class Devox {
//
//    public static void main(String[] args) {
//
//
//        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
////        numbers2.forEach(new Consumer<Integer>(){
////            @Override
////            public void accept(Integer integer) {
////                System.out.println(integer);
////            }
////        } );
//
//        System.out.println(
//            numbers2.stream()
//                    .reduce(0, Integer::sum)
//        );
//    }
//}
import java.util.ArrayList;
import java.util.List;

public class Devox {
    public static String calculateAverage(String[] marks) {
        List<String> result = new ArrayList<>();
        for (String mark : marks) {
            String[] parts = mark.split("\\s+"); // split by whitespace
            String name = "";
            int sum = 0;
            int count = 0;
            for (String part : parts) {
                if (Character.isDigit(part.charAt(0))) {
                    int markValue = Integer.parseInt(part);
                    if (markValue >= 1 && markValue <= 10) {
                        sum += markValue;
                        count++;
                    }
                } else {
                    name += part + " ";
                }
            }
            if (count > 0) {
                double average = (double) sum / count;
                result.add(name.trim() + "-" + Math.round(average) + ";");
            } else {
                result.add(name.trim() + "-e;");
            }
        }
        return String.join(" ", result);
    }

    public static void main(String[] args) {
//        String[] input2 = {"Denver Wagner 6 7 8, Ernie Gibbs 11 2"};
        String[] input = {"Madeline Choi 5 5 6", "Ethan Wyatt 8 9 10"};
        String output = calculateAverage(input);
        System.out.println(output);
//        System.out.println(calculateAverage(input2));
    }
}
