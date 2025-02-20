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
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue).reversed()).forEach(System.out::println);

        //        find all unique cities where the traders work
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);

        //        find all traders from Cambridge and sort them by name
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).forEach(System.out::println);

        //        return a string of all traders' names sorted alphabetically
        var traderNames = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderNames);

        //        are any traders based in Milan?
        var milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //        print all transactions' values from the traders living in Cambridge
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        //        what's the highest value of all the transactions?
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(value -> System.out.println("Highest value: " + value));

        //        what's the smallest value of all the transactions?
        transactions.stream().map(Transaction::getValue).reduce(Integer::min).ifPresent(value -> System.out.println("Smallest value: " + value));

    }

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader jen = new Trader("Jen", "Milan");

        return List.of(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(jen, 2012, 950));
    }
}
