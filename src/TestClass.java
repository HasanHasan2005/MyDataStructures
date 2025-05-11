package src;

import src.Stacks.StackArray;
import src.Stacks.StackLinkedList;

public class TestClass {
    public static void main(String[] args) {
        StackLinkedList<Integer> ll = new StackLinkedList<>();
        StackArray<Integer> arr = new StackArray<>(new Integer[10000000]);
        ll.push(1);
        arr.push(1);

        long llTime = 0;
        long arrTime = 0;

        for (int i = 0; i < 2000000; i++) {
            llTime -= System.nanoTime();
            ll.peek();
            llTime += System.nanoTime();

            arrTime -= System.nanoTime();
            arr.peek();
            arrTime += System.nanoTime();
        }

        System.out.println(llTime);
        System.out.println(arrTime);
    }
}
