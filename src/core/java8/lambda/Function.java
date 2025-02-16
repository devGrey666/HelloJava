package core.java8.lambda;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
