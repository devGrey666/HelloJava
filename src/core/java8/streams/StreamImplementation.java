package core.java8.streams;

import core.Base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImplementation implements Base {
    @Override
    public void run() {
        System.out.println("Stream Implementation");

//        use constructor reference to create a list of dishes

        List<Dish> menu = List.of(new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

//        filter values based on a predicate
        var vegetarianDishes = menu.stream().filter(Dish::isVegetarian).toList();
        System.out.println(vegetarianDishes);

//        filter values based on a predicate and return unique values
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 6, 7, 8, 9, 10, 8);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

//        limit the number of values returned
        numbers.stream().filter(i -> i % 2 == 0).distinct().limit(3).forEach(System.out::println);

//        skip the number of values returned
        numbers.stream().filter(i -> i % 2 == 0).distinct().skip(1).forEach(System.out::println);

//        map the values to another value
        menu.stream().map(Dish::getName).forEach(System.out::println);

//        filter the first two meat dishes
        menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).limit(2).forEach(System.out::println);

//        flatMap the values
        List<String> words = List.of("Hello", "World");
        words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

//        find the square of each number in a list
        List<Integer> numbersList = List.of(1, 2, 3, 4, 5);
        numbersList.stream().map(i -> i * i).forEach(System.out::println);

        //        use two lists of numbers to find each pair of numbers

        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(3, 4);
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

    }
}
