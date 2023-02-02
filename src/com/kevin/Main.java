package com.kevin;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Consumer<String> snuffles = s -> System.out.println(s);
        snuffles.accept("nope");

        blowBubbles((final var b) -> b > 2);

        Supplier<Character> ruffles = () -> 'E';
        Character character = ruffles.get();
        System.out.println(character);

        StringBuilder sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);

        int two = (int) Math.round(1.0);

        float three = (float) Math.random();

        String[] names = {"Tom", "Dick", "Harry"};
        //  List<String> list = names.asList();

        //   Function function = System.out::println;

        //PrintStream::println;

        //Connection;

        //  JFrame

        long longer = Long.MAX_VALUE;
        float floater = Float.MAX_VALUE;
        float v = floater + longer;
        System.out.println(longer);
        System.out.println(floater);
        System.out.println(v);

    }


    static void blowBubbles(Predicate<Integer> bubbles) {

        bubbles.test(5);
    }
}
