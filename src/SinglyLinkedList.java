package src;

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
        if (size == 0) throw new IllegalArgumentException("Can't access an empty list");

        if (i < 0 || i >= size) throw new IllegalArgumentException("List index out of bounds");

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


    protected Node<E> insertNode(int i, E elem) {
        if (i < 0 || i > size) throw new IllegalArgumentException("List index out of bounds");

        size++;
        if (i == 0) {
            head = new Node<>(elem, head);
            return head.next;
        }

        Node<E> curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }
        Node<E> newNode = new Node<>(elem, curr.getNext());
        curr.next = newNode;

        return newNode.next;
    }


    public E insert(int i, E elem) {
        Node<E> oldNode = insertNode(i, elem);
        return (oldNode == null) ? null : oldNode.getElem();
    }

    public E insertLast(E elem) {return insert(size, elem);}

    public E insertFirst(E elem) {return insert(0, elem);}



    protected Node<E> removeNode(int i) {
        if (size == 0) throw new IllegalArgumentException("Can't remove node from an empty list");

        if (i < 0 || i >= size) throw new IllegalArgumentException("List index out of bounds");

        size--;
        if (i == 0) {
            Node<E> toRemove = head;
            head = head.next;
            return toRemove;
        }

        Node<E> curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }
        Node<E> oldNode = curr.next;
        curr.next = oldNode.next;
        return oldNode;
    }

    public E remove(int i) {
        return removeNode(i).getElem();
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
        E elem;
        Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

        public E getElem() {return elem;}

        public Node<E> getNext() {return next;}

        public E setElem(E newElem) {
            E old = elem;
            elem = newElem;
            return old;
        }
    }
}
