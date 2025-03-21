package Lists.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        MyDLinkedList<String> myList = new MyDLinkedList<String>();
        myList.append("f");
        myList.prepend("i");
        myList.append("c");
        myList.append("e");
        myList.insert(0, "b");
        myList.append("a");
        myList.append("g");
        myList.insert(7, "d");
        myList.prepend("h");
        myList.printList();
        myList.mergeSort();
        myList.printList();
    }
}