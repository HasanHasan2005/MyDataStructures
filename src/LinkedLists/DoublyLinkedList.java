package src.LinkedLists;

import src.Interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    //TODO
    //Needs debugging
    protected int size;
    protected Node<E> head;
    protected Node<E> tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    protected Node<E> getNode(int i) {
        checkForException(i, false, size);

        Node<E> curr;
        if (i > size / 2) {
            curr = tail;
            for (int j = size - 1; j > i; j--) {
                curr = curr.prev;
            }
            return curr;
        }
        curr = head;
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
        if (size == 1) {
            Node<E> newNode = new Node<>(elem, null, null);
            head = newNode;
            tail = newNode;
            return null;
        }

        if (i == 0) {
            head.setPrev(new Node<>(elem, head, null));
            head = head.getPrev();
            return head.getNext().getElem();
        }

        if (i == size) {
            tail.setNext(new Node<>(elem, null, tail));
            tail = tail.getNext();
            return tail.getPrev().getElem();
        }

        Node<E> curr = getNode(i);
        Node<E> newNode = new Node<>(elem, curr.getPrev(), curr);
        curr.getPrev().setNext(newNode);
        curr.setPrev(newNode);
        return curr.getElem();

    }

    public E insert(int i, E elem) {
        return insertNode(i, elem);
    }

    public E insertLast(E elem) {return insert(size, elem);}

    public E insertFirst(E elem) {return insert(0, elem);}

    protected E removeNode(int i) {
        checkForException(i, false, size);

        size--;
        if (size == 0) {
            E old = head.getElem();
            head = null;
            tail = null;
            return old;
        }

        if (i == 0) {
            E old = head.getElem();
            head = head.getNext();
            head.setPrev(null);
            return old;
        }

        if (i == size - 1) {
            E old = tail.getElem();
            tail = tail.getPrev();
            tail.setNext(null);
            return old;
        }

        Node<E> curr = getNode(i);
        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());
        return curr.getElem();
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
        protected Node<E> prev;

        public Node(E elem, Node<E> next, Node<E> prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        public E getElem() {return elem;}

        public Node<E> getNext() {return next;}

        public Node<E> getPrev() {return prev;}

        public void setNext(Node<E> newNext) {
            next = newNext;
        }

        public void setPrev(Node<E> newPrev) {
            prev = newPrev;
        }

        public E setElem(E newElem) {
            E old = elem;
            elem = newElem;
            return old;
        }
    }
}
