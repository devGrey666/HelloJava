package core.behavior.parameterization;

import core.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * demonstrates behavior parameterization with a predicate.
 */
public class PredicateFilterExample implements Base {
    Logger log = Logger.getLogger(PredicateFilterExample.class.getName());

    @Override
    public void run() {
//        list of strings and filter out the strings with length less than 6
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hello");
        listOfStrings.add("World");
        listOfStrings.add("Goodbye");
        listOfStrings.add("Cruel");
        listOfStrings.add("World");

        List<String> shortStrings = filter(listOfStrings, s -> s.length() < 6);
        log.info(shortStrings.toString());


//        list of random integers and filter out the even numbers
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);
        listOfIntegers.add(5);
        listOfIntegers.add(6);
        listOfIntegers.add(7);
        listOfIntegers.add(8);
        listOfIntegers.add(9);
        listOfIntegers.add(10);

        List<Integer> evenNumbers = filter(listOfIntegers, i -> i % 2 == 0);
        log.info(evenNumbers.toString());


    }

    /**
     * Behavior parameterization with a predicate. ?? Predicate is a functional interface.
     * Filter a list of elements using a predicate.
     */

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

}
