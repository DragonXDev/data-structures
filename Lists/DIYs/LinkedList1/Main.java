package Lists.DIYs.LinkedList1;

public class Main {
    public static void main(String[] args) {
        MySLinkedList myList = new MySLinkedList();

        System.out.println(myList.size());

        myList.append(19);

        myList.prepend(4);

        myList.printList();

        System.out.println(myList.get(1));

        System.out.println(myList.get(10));
    }
}