package lambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class VenkatDevoxLamda {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println(mapReduce(nums));
        System.out.println(doubleEvenPutBackIntoList(numbers));

        VenkatDevoxLamda venkatDevoxLamda = new VenkatDevoxLamda();
        VenkatDevoxLamda.nameAsKeyAndValueAsNamesWithThatName();
        nameAsKeyAndValueAsAgesWithThatName();
    }

    public static List<Person> createPeople() {
        return Arrays.asList(new Person("Sara", Gender.FEMALE, 24), new Person("John", Gender.MALE, 30), new Person("Emily", Gender.FEMALE, 28), new Person("Michael", Gender.MALE, 27), new Person("Emma", Gender.FEMALE, 26), new Person("Daniel", Gender.MALE, 32), new Person("Micheal", Gender.FEMALE, 27), new Person("Sara", Gender.MALE, 28), new Person("Sophia", Gender.FEMALE, 25), new Person("Matthew", Gender.MALE, 24));
    }

    // given a list of people, create a map where
    // their name is the key and value is all the people with that name

    public static void nameAsKeyAndValueAsNamesWithThatName() {
        List<Person> personList = createPeople();

        System.out.println(
                personList.stream().collect(groupingBy(Person::getName))
        );

    }

    // given a list of people, create a map where
    // their name is the key and value is all the ages with that name
    public static void nameAsKeyAndValueAsAgesWithThatName() {
        List<Person> personList = createPeople();
        System.out.println(
                personList.stream().collect(groupingBy(Person::getName, mapping(Person::getAge, toList())))
        );


    }

    public static String mapReduce(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).reduce("", String::concat);

    }

    public static List<Integer> doubleEvenPutBackIntoList(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).map(num -> num * 2).collect(Collectors.toList());
    }

}
