package src.Trees;
import src.Interfaces.BinaryTree;

public class LinkedBinaryTree<E> implements BinaryTree<E> {

    Node<E> root = null;
    int size = 0;

    public LinkedBinaryTree() {}



    protected static class Node<E> {
        E elem;
        Node<E> left;
        Node<E> right;

        public Node(E elem, Node<E> left, Node<E> right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        public E getElem() {return elem;}

        public Node<E> getLeft() {return left;}

        public Node<E> getRight() {return right;}

        public E setElem(E newElem) {
            E old = elem;
            elem = newElem;
            return old;
        }

        public Node<E> setLeft(Node<E> newLeft) {
            Node<E> old = left;
            left = newLeft;
            return old;
        }

        public Node<E> setRight(Node<E> newRight) {
            Node<E> old = right;
            right = newRight;
            return old;
        }
    }
}
