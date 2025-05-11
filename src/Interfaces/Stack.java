package src.Interfaces;

import java.util.Iterator;

public interface Stack<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    void push(E elem);

    E pop();

    E peek();

    Iterator<E> iterator();

    default void checkForException() {

    }
}
