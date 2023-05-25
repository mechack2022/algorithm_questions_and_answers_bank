package leetcodes;

/*
Evaluate Reverse Polish Notation The problem:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another
expression.
Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.Stack;
import java.util.stream.Stream;

public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(reversePolishNotation(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(reversePolishNotation(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(reversePolishNotation(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int reversePolishNotation(String[] tokens) {

        String operators = "+/*-";
        Stack<String> stack = new Stack<>();
//        loop through tokens if s is not an operator, push to the stack
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(s);
            }
            else {
                // pop the two topmost values and do the calculation base on the encounter operator
                Integer  a = Integer.valueOf(stack.pop());
                Integer b = Integer.valueOf(stack.pop());
                int operatorIndex = operators.indexOf(s);
                switch (operatorIndex) {
                    case 0 -> stack.push(String.valueOf(a + b));
                    case 1 -> stack.push(String.valueOf(a / b));
                    case 2 -> stack.push(String.valueOf(a * b));
                    case 3 -> stack.push(String.valueOf(a - b));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }



    public static int reversePolishNotation2(String[] tokens) {
        String operators = "+/*-";
        Stack<String> stack = new Stack<>();

        Stream.of(tokens)
                .forEach(s -> {
                    if (!operators.contains(s)) {
                        stack.push(s);
                    } else {
                        Integer a = Integer.valueOf(stack.pop());
                        Integer b = Integer.valueOf(stack.pop());
                        int operatorIndex = operators.indexOf(s);
                        stack.push(
                                switch (operatorIndex) {
                                    case 0 -> String.valueOf(a + b);
                                    case 1 -> String.valueOf(a / b);
                                    case 2 -> String.valueOf(a * b);
                                    case 3 -> String.valueOf(a - b);
                                    default -> throw new IllegalArgumentException("Invalid operator: " + s);
                                }
                        );
                    }
                });

        return Integer.parseInt(stack.pop());
    }







}
