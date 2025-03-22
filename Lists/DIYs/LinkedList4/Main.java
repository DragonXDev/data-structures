package Lists.DIYs.LinkedList4;

public class Main {
    public static void main(String[] args) {
        MyDLinkedList<Integer> myList = new MyDLinkedList<Integer>();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.prepend(100);
        myList.insert(0, 15);
        myList.insert(5, 8);
        myList.insert(2, 6);
        myList.printList();
        System.out.println(myList.remove(Integer.valueOf(100)));
        myList.printList();
        System.out.println(myList.remove(3));
        myList.printList();
        System.out.println(myList.indexOf(6));
        Node<Integer> n = myList.get(Integer.valueOf(3));
        n = myList.remove(n);
        System.out.println(n);
        System.out.println("Removed's previous: " + n.getPrevious());
        System.out.println("Removed's next: " +n.getNext());
        myList.printList();
        System.out.println(myList.get(Integer.valueOf(123)));
        System.out.println(myList.indexOf(Integer.valueOf(123)));
        myList.printListBackward();
    }
}