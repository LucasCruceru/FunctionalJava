package ro.lucas.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyStreams {

    private static int length(final String name){
        System.out.println("Getting length for "+ name + ".");
        return name.length();
    }
    private static String toUpper(final String name) {
        System.out.println("Converting " + name + " to uppercase.");
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
                "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        Stream<String> namesWith3Letters =
                names.stream()
                    .filter(name -> length(name) == 3)
                    .map(LazyStreams::toUpper);

        System.out.println("Stream created, filtered, mapped...");
        System.out.println("ready to call findFirst...");

        final String firstNameWith3Letters =
                    namesWith3Letters.findFirst()
                            .get();

        System.out.println(firstNameWith3Letters);
    }
}