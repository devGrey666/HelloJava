package core.java8.lambda;

import core.Base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparing implements Base {
    @Override
    public void run() {
        System.out.println("Comparing");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 25));
        personList.add(new Person("Jane", 20));
        personList.add(new Person("Doe", 30));
        personList.add(new Person("Smith", 35));
        personList.add(new Person("Sam", 35));
        personList.add(new Person("Doe", 40));
        personList.add(new Person("Smith", 45));

        personList.sort(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName));

//        print the sorted list with name and age of each person
        personList.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
    }
}
