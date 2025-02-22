package core.java8.streams;

public record Trader(String name, String city) {

    @Override
    public String toString() {
        return "Trader{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }
}
