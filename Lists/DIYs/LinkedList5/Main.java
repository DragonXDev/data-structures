package Lists.DIYs.LinkedList5;

public class Main {
    public static void main(String[] args) {
        MyDLinkedList<String> listTwo = new MyDLinkedList<String>();
        listTwo.append("f");
        listTwo.append("i");
        listTwo.append("c");
        listTwo.append("e");
        listTwo.append("b");
        listTwo.append("a");
        listTwo.append("g");
        listTwo.append("d");
        listTwo.append("h");
        listTwo.printList();
        listTwo.mergeSort();
        listTwo.printList();
    }
}