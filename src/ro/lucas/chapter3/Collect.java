package ro.lucas.chapter3;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class Collect {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );
        List<Person> olderThan20 =people.stream()
                .filter(person -> person.getAge() >20)
                .collect(Collectors.toList());
        System.out.println("People older than 20: "+ olderThan20);
        System.out.println("--------------------------");

        Map<Integer, List<Person>> peopleByAge =
                people.stream()
                        .collect(groupingBy(Person::getAge));
        System.out.println("Grouped by age: " + peopleByAge);
        System.out.println("--------------------------");

        Map<Integer, List<String>> nameOfPeopleByAge =
                people.stream()
                .collect(
                        groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println("People grouped by age: " + nameOfPeopleByAge);
        System.out.println("--------------------------");

        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                people.stream()
                        .collect(groupingBy(person -> person.getName().charAt(0),
                        reducing(BinaryOperator.maxBy(byAge))));
        System.out.println("Oldest person of each letter:");
        System.out.println(oldestPersonOfEachLetter);
        System.out.println("--------------------------");
    }
}
