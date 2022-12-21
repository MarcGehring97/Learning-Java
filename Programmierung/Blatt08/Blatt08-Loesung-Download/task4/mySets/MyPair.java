package mySets;

public class MyPair<T,U> {
    private T first;
    private U second;

    public MyPair(T t, U u) {
        first = t;
        second = u;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
