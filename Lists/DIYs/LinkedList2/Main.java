package Lists.DIYs.LinkedList2;

public class Main {
    public static void main(String[] args) {
MySLinkedList<Integer> myList = new MySLinkedList<Integer>();

myList.append(1);

myList.append(2);

myList.append(3);

myList.printList();

myList.prepend(100);

myList.insert(0, 15);

myList.insert(10, 9);

myList.insert(5, 8);

myList.insert(2, 6);

myList.printList();

System.out.println(myList.get(4));
    }
}