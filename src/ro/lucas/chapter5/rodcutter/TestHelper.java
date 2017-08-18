package ro.lucas.chapter5.rodcutter;

import static org.junit.jupiter.api.Assertions.fail;

public class TestHelper {
    public static <X extends Throwable> Throwable assertThrows(
            final Class<X> exceptionClass, final Runnable block) {
        try {
            block.run();
        } catch (Throwable e) {
            if (exceptionClass.isInstance(e))
                return e;
        }
        fail("Failed to throw expected exception");
        return null;
    }
}