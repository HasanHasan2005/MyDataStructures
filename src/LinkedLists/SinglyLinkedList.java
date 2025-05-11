package src.LinkedLists;

import src.Interfaces.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    protected int size;
    protected Node<E> head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    protected Node<E> getNode(int i) {
        checkForException(i, false, size);

        Node<E> curr = head;
        for (int j = 0; j < i; j++) {
            curr = curr.next;
        }
        return curr;
    }

    public E get(int i) {
        return getNode(i).getElem();
    }

    public E getFirst() {return get(0);}

    public E getLast() {return get(size - 1);}

    public E set(int i, E newElem) {
        return getNode(i).setElem(newElem);
    }

    protected E insertNode(int i, E elem) {
        checkForException(i, true, size);

        size++;
        if (i == 0) {
            head = new Node<>(elem, head);
            return (size == 1) ? null : head.getNext().getElem();
        }

        Node<E> curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }

        E old = (i == size - 1) ? null : curr.getNext().getElem();
        curr.setNext(new Node<>(elem, curr.getNext()));
        return old;
    }

    public E insert(int i, E elem) {
        return insertNode(i, elem);
    }

    public E insertLast(E elem) {return insert(size, elem);}

    public E insertFirst(E elem) {return insert(0, elem);}

    protected E removeNode(int i) {
        checkForException(i, false, size);

        size--;
        if (i == 0) {
            E toRemove = head.getElem();
            head = head.next;
            return toRemove;
        }

        Node<E> curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }

        E old = curr.getNext().getElem();
        curr.setNext(curr.getNext().getNext());
        return old;
    }

    public E remove(int i) {
        return removeNode(i);
    }

    public E removeLast() {return remove(size - 1);}

    public E removeFirst() {return remove(0);}


    public Iterator<E> iterator() {
        //TODO
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (size > 0) {
            Node<E> curr = head;
            sb.append(curr.getElem());
            curr = curr.next;

            while (curr != null) {
                sb.append(", ");
                sb.append(curr.getElem());
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected static class Node<E> {
        protected E elem;
        protected Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

        public E getElem() {return elem;}

        public Node<E> getNext() {return next;}

        public void setNext(Node<E> newNext) {
            next = newNext;
        }

        public E setElem(E newElem) {
            E old = elem;
            elem = newElem;
            return old;
        }
    }
}
