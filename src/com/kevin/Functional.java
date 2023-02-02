package com.kevin;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Functional {

    public static void main(String[] args) {
        var functional = new Functional();
        // functional.optional();
        functional.streams();
    }

    private void optional() {
        Optional<Zebra> optional = Optional.empty();

        try {
            System.out.println(optional.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());


        System.out.println(optional.orElse(new WingedZebra("Steve", 100)));

        optional.ifPresent(System.out::println);

        final var wingedZebraConsumer = new WingedZebraConsumer();

        //optional.ifPresent(wingedZebraConsumer);

        System.out.println(optional.orElseGet(() -> new WingedZebra("Zabulisus", 10)));

        System.out.println("filled optional");

        final var filledOptional = Optional.of(new Zebra("Lucious", 84));

        filledOptional.ifPresent(zebra -> {
            zebra.revokeStripe();
            System.out.println(zebra);
        });
    }

    private void streams() {


        Stream<String> empty = Stream.empty();

        List<Integer> randomIntStream = Stream.generate(Math::random)
                .map(aDouble -> (int) (aDouble * 6 + 1))
                .filter(roll -> roll != 1)
                .limit(10)
                .collect(Collectors.toList());

        List<Integer> randomIntStream2 = Stream.generate(new Random()::nextInt)
                .limit(10)
                .collect(Collectors.toList());

        Stream.generate(Math::random)
                .map(aDouble -> (int) (aDouble * 6 + 1))
                .filter(roll -> roll != 1)
                .limit(10)
                .forEach(System.out::print);

        System.out.println("");
        System.out.println("ordered: ");

        Stream.generate(Math::random)
                .map(aDouble -> (int) (aDouble * 6 + 1))
                .filter(roll -> roll != 1)
                .limit(10)
                .forEachOrdered(System.out::print);

        System.out.println("");
        System.out.println("random Int Stream 1: " + randomIntStream);
        System.out.println("random Int Stream 2: " + randomIntStream2);

        Stream<Pen> penStream = Stream.of(
                new Pen(List.of("marmoset", "platypus", "wombat")),
                new Pen(List.of("zebra", "dog", "cat", "tiger", "monkey"))
        );

        System.out.println("penStream: ");
        penStream.flatMap(pen -> pen.getAnimals().stream())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        boolean matchBool = Stream.iterate(7, it -> ++it)
                .peek(System.out::println)
                .anyMatch(that -> Integer.valueOf(9).equals(that));

        System.out.println("match Bool: " + matchBool);

        long count = Stream.iterate(10, num -> num < 15, i -> ++i)
                .peek(System.out::println)
                .count();

        System.out.println("count: " + count);

        IntSummaryStatistics intSummaryStatistics = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .mapToInt(i -> i)
                .summaryStatistics();

        System.out.println("intSummaryStatistics: " + intSummaryStatistics);

        int sum = IntStream.range(5, 11).sum();
        System.out.println("sum: " + sum);

        int sum2 = IntStream.rangeClosed(5, 10).sum();
        System.out.println("sum2: " + sum2);

        OptionalDouble average = LongStream.rangeClosed(1, Integer.MAX_VALUE).parallel().average();

        System.out.println(average);

        Optional<String> reduced = Stream.of("A", "p", "p", "l", "e").reduce((a, b) -> a + b);
        System.out.println("reduced: " + reduced);

        String reduced2 = Stream.of("A", "p", "p", "l", "e").reduce("", (a, b) -> a + b);
        System.out.println("reduced2: " + reduced2);

        Integer reduced3 = Stream.of("A", "pp", "l", "e").reduce(0, (i, s) -> i + s.length(), Integer::sum);
        System.out.println("reduced3: " + reduced3);
    }
}

class WingedZebraConsumer implements Consumer<WingedZebra> {

    @Override
    public void accept(WingedZebra wingedZebra) {
        System.out.println(wingedZebra);
    }
}

class Pen {

    private List<String> animals;

    public Pen(List<String> animals) {

        this.animals = animals;
    }

    public List<String> getAnimals() {
        return animals;
    }
}
