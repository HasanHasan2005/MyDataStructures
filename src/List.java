package src;
import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    int size();
    boolean isEmpty();

    E get(int i);
    E getFirst();
    E getLast();

    E insert(int i, E elem);
    E insertLast(E elem);
    E insertFirst(E elem);

    E remove(int i);
    E removeLast();
    E removeFirst();


    Iterator<E> iterator();
}
