package core.lambda;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T s);
}
