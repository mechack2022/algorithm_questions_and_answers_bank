package lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Devox {

    public static void main(String[] args) {


        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        numbers2.forEach(new Consumer<Integer>(){
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        } );

        System.out.println(
            numbers2.stream()
                    .reduce(0, Integer::sum)
        );
    }
}
