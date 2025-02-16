package core.lambda;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
