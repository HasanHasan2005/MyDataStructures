package src.Interfaces;
import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    int size();
    boolean isEmpty();

    E get(int i);

    E set(int i, E elem);

    E insert(int i, E elem);

    E remove(int i);

    Iterator<E> iterator();

    default void checkForException(int i, boolean isInsert, int size) {
        if (size == 0 && !(isInsert && i == 0)) throw new IllegalArgumentException("Can't access an empty list");

        if (i < 0 || i > size) throw new IllegalArgumentException("List index out of bounds");

        if (i == size && !isInsert) throw new IllegalArgumentException("List index out of bounds");
    }
}
