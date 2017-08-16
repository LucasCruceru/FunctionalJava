package ro.lucas.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

class Compare {

    public static void main(String[] args) {

        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );

        Comparator<Person> compareAscending = Person::ageDifference;
        Comparator<Person> compareDescending = compareAscending.reversed();

        final Function<Person, String> byName = Person::getName;
        final Function<Person, Integer> byAge = Person::getAge;


        printPeople("Sorted in ascending order by age: ",
                people.stream()
                        .sorted(compareAscending)
                        .collect(toList()));
        System.out.println("--------------------------");
        printPeople("Sorted in descending order by age: ",
                people.stream()
                      .sorted(compareDescending)
                      .collect(toList()));
        System.out.println("--------------------------");
        printPeople("Sorted in ascending order name",
                people.stream()
                        .sorted(comparing(Person::getName))
                        .collect(toList())
        );
        System.out.println("--------------------------");
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("The youngest is " + youngest));
        System.out.println("--------------------------");
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println("The eldest is " + eldest));
        System.out.println("--------------------------");
        printPeople("Sorted in ascending order by age and name: ",
                people.stream()
                .sorted(comparing(byAge).thenComparing(byName))
                .collect(toList()));

    }

    private static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}



