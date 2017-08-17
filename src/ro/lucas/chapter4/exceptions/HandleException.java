package ro.lucas.chapter4.exceptions;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {
    public static void main(String[] args) throws IOException{
        Stream.of("/usr", "/tmp")
                .map(HandleException::apply)
                .forEach(System.out::println);
    }

    private static String apply(String path) {
        try {
            return new File(path).getCanonicalPath();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
