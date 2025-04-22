package core.java8.streams;

public record Transaction(Trader trader, int year, int value) {

    @Override
    public String toString() {
        return "Transaction{" + "trader=" + trader + ", year=" + year + ", value=" + value + '}';
    }
}
