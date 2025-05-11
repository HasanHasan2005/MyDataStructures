package src.Stacks;

import src.Interfaces.Stack;
import src.LinkedLists.SinglyLinkedList;

import java.util.Iterator;

public class StackLinkedList<E> implements Stack<E> {
    protected int size;
    protected Node<E> top;

    public StackLinkedList() {
        size = 0;
        top = null;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}


    public void push(E elem) {
        top = new Node<>(elem, top);
        size++;
    }

    public E pop() {
        if (size == 0) return null;

        E old = top.elem;
        top = top.next;
        size--;
        return old;
    }

    public E peek() {return top.elem;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (size > 0) {
            Node<E> curr = top;
            sb.append(curr.elem);
            curr = curr.next;

            while (curr != null) {
                sb.insert(1, ", ");
                sb.insert(1, curr.elem);
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        //TODO
        return null;
    }

    protected static class Node<E> {
        protected E elem;
        protected Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
