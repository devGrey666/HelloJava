package core.java8.lambda;

import core.Base;

import java.util.List;

public class ConsumerExample implements Base {
    @Override
    public void run() {
        List<String> listOfStrings = List.of("Hello", "World", "Goodbye", "Cruel", "World");
        forEach(listOfStrings, s -> System.out.print(s + " "));

        List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        forEach(listOfIntegers, i -> System.out.print(i + " "));
    }

    private static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }
}
