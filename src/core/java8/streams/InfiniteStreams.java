package core.java8.streams;

import core.Base;

import java.util.stream.Stream;

public class InfiniteStreams implements Base {
    @Override
    public void run() {

//       print first 10 integers starting from 1
        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

//        generate the first 10 even numbers
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

//        generate 10 numbers starting from 2 and doubling each time
        Stream.iterate(2, n -> n * 2).limit(10).forEach(System.out::println);

//        generate 10 Fibonacci numbers
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(10).forEach(n -> System.out.println(n[0] + ", " + n[1]));

//    generate 10 random numbers
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
