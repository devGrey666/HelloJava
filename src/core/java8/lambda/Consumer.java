package core.java8.lambda;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T s);
}
