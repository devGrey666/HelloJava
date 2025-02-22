package core.java8.streams;

public record Dish(String name, boolean vegetarian, int calories, core.java8.streams.Dish.Type type) {

    @Override
    public String toString() {
        return "Dish{" + "name='" + name + '\'' + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + '}';
    }

    public enum Type {MEAT, FISH, OTHER}
}