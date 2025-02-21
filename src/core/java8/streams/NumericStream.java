package core.java8.streams;

import core.Base;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream implements Base {
    @Override
    public void run() {
        var transactions = getTransactions();

//        mapping to a numeric stream
        var sum = transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.println("Sum of all transactions: " + sum);

//        converting back to object stream
        IntStream intStream = transactions.stream().mapToInt(Transaction::getValue);
        Stream<Integer> transactionStream = intStream.boxed();

//        optional value for numeric streams
        OptionalInt max = transactions.stream().mapToInt(Transaction::getValue).max();
        int maxInt = max.orElse(1);
        System.out.println("Max value: " + maxInt);

//        numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println("Even numbers count: " + evenNumbers.count());


//        generate pythagorean triples
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0));
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


    }


    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader jen = new Trader("Jen", "Milan");

        return List.of(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(jen, 2012, 950));
    }
}
