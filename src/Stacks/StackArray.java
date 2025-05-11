package src.Stacks;

import src.Interfaces.Stack;

import java.util.Iterator;

public class StackArray<E> implements Stack<E> {

    E[] stack;
    int topIndex;
    int maxSize;

    public StackArray(E[] emptyStack) {
        stack = emptyStack;
        maxSize = emptyStack.length - 1;
        topIndex = -1;
    }

    public int size() {return topIndex + 1;}

    public boolean isEmpty() {return topIndex == -1;}

    public void push(E elem) {
        if (topIndex + 1 > maxSize) {
            throw new IllegalArgumentException("Stack is full!");
        }
        topIndex++;
        stack[topIndex] = elem;
    }

    public E pop() {
        if (topIndex == -1) {
            return null;
        }
        E old = stack[topIndex];
        topIndex--;
        return old;
    }

    public E peek() {return stack[topIndex];}

    public Iterator<E> iterator() {
        //TODO
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (topIndex >= 0) {
            sb.append(stack[0]);
            for (int i = 1; i <= topIndex; i++) {
                sb.append(", ");
                sb.append(stack[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
