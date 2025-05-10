package src;

public class TestClass {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        sll.insertFirst(1);
        System.out.println(sll);
        sll.insertLast(3);
        System.out.println(sll);
        sll.insert(1, 2);
        System.out.println(sll);

        System.out.println(sll);
        System.out.println(sll.get(1));
        System.out.println(sll.getFirst());
        System.out.println(sll.getLast());

        sll.removeLast();
        sll.remove(1);

        System.out.println(sll);
    }
}
