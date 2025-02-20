package core.java8.streams;

import core.Base;

import java.util.List;

/**
 * Stream Example, All examples are taken from the book Java 8 in Action by Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft
 */
public class StreamExample implements Base {
    @Override
    public void run() {
        System.out.println("Stream Example");

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader jason = new Trader("Jason", "Cambridge");
        Trader jen = new Trader("Jen", "Milan");

        var transactions = List.of(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(jen, 2012, 950));


        //        find all transactions in the year 2011 and sort them by value (high to small)
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted((t1, t2) -> t2.getValue() - t1.getValue()).forEach(System.out::println);


    }
}
