package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleConsumerFunctionAndSupplier {

    private static final List<String> arr = Arrays.asList("Gbenga", "Tolu", "Franc", "Loveth", "Raymound");

    public static void main(String[] args) {
        SimpleConsumerFunctionAndSupplier sim = new SimpleConsumerFunctionAndSupplier();
        Consumer<String> greetingConsumers = sim.greeting();
        greetingConsumers.accept("Good morning sir");

        Function<List<String>, String> greetVend = sim.greetVendors();
        greetVend.apply(arr);
    }

    public Consumer<String> greeting() {
        Supplier<List<String>> vendors = suppliesVendorsNames();
        return (greet -> vendors.get().forEach(item -> System.out.println(greet + " " + item)));

    }

    public Supplier<List<String>> suppliesVendorsNames() {
        return () -> arr;
    }

    public Function<List<String>, String> greetVendors() {
        return names -> {
            names.forEach(name -> {
                System.out.println(supplyGreeting().get()+ ", " + name);
            });
            return "Greetings sent!";
        };
    }

    private Supplier<String> supplyGreeting() {
        return () -> "Hello";
    }


}
