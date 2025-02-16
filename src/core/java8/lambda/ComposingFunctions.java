package core.java8.lambda;

import java.util.function.Function;
import core.Base;

public class ComposingFunctions implements Base {
    @Override
    public void run() {
        System.out.println("Composing Functions");

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer, Integer> h = g.compose(f);
        System.out.println(h.apply(1));

    }
}
