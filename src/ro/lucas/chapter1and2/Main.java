package ro.lucas.chapter1and2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;

class Main {

    public static void main(String[] args) {

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println(String.join(", ", friends));
        System.out.println(friends.stream()
                                .map(String::toUpperCase)
                                .collect(joining(", ")));

        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        friends.stream()
                .map(String::toUpperCase)
                .filter(startsWithLetter.apply("N"))
                .forEach(System.out::println);

        pickName(friends, "N");
        pickName(friends, "Z");

        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(String::length)
                        .sum());

        final Optional<String> aLongName =
                friends.stream()
                        .reduce((name1,name2) ->
                                name1.length() >= name2.length()? name1 : name2);
        aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));


        final String steveOrLonger =
                friends.stream()
                .reduce("Steve",(name1,name2) ->
                        name1.length() >= name2.length()? name1:name2);

    }

    private static void pickName (
            final List<String> names, final String startingLetter
    ){
        final Optional<String> foundName =
                names.stream()
                        .filter(name -> name.startsWith(startingLetter))
                        .findFirst();

        System.out.println(String.format("A name stating with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
