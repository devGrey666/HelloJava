package core.lambda;

import core.Base;

import java.util.ArrayList;
import java.util.List;


public class FunctionExample implements Base {
    @Override
    public void run() {
        List<String> listOfStrings = List.of("Hello", "World", "Goodbye", "Cruel", "World");
        List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> lengths = map(listOfStrings, s -> s.length());
        System.out.println(lengths);
        List<Integer> squares = map(listOfIntegers, i -> i * i);
        System.out.println(squares);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(f.apply(t));
        }
        return results;
    }

}
