package core.java8.streams;

import core.Base;

import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Stream Example, All examples are taken from the book Java 8 in Action by Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft
 */
public class StreamExample implements Base {
    @Override
    public void run() {
        System.out.println("Stream Example");

        var transactions = getTransactions();


        //        find all transactions in the year 2011 and sort them by value (high to small)
        transactions.stream().filter(transaction -> transaction.year() == 2011).sorted(comparing(Transaction::value).reversed()).forEach(System.out::println);

        //        find all unique cities where the traders work
        transactions.stream().map(transaction -> transaction.trader().city()).distinct().forEach(System.out::println);

        //        find all traders from Cambridge and sort them by name
        transactions.stream().map(Transaction::trader).filter(trader -> trader.city().equals("Cambridge")).distinct().sorted(comparing(Trader::name)).forEach(System.out::println);

        //        return a string of all traders' names sorted alphabetically
        var traderNames = transactions.stream().map(transaction -> transaction.trader().name()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderNames);

        //        are any traders based in Milan?
        var milanBased = transactions.stream().anyMatch(transaction -> transaction.trader().city().equals("Milan"));
        System.out.println(milanBased);

        //        print all transactions' values from the traders living in Cambridge
        transactions.stream().filter(transaction -> transaction.trader().city().equals("Cambridge")).map(Transaction::value).forEach(System.out::println);

        //        what's the highest value of all the transactions?
        transactions.stream().map(Transaction::value).reduce(Integer::max).ifPresent(value -> System.out.println("Highest value: " + value));

        //        find the transaction with the smallest value
        transactions.stream().min(comparing(Transaction::value)).ifPresent(value -> System.out.println("Smallest value: " + value));

    }

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader jen = new Trader("Jen", "Milan");

        return List.of(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(jen, 2012, 950));
    }
}
