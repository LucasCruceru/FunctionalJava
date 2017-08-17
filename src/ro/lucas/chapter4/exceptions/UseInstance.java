package ro.lucas.chapter4.exceptions;

@FunctionalInterface
public interface UseInstance<T,X extends Throwable> {
    void accept(T instance) throws X;
}