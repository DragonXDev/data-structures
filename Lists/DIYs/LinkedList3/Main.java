package Lists.DIYs.LinkedList3;

public class Main {
    public static void main(String[] args) {
MySLinkedList<Integer> myList = new MySLinkedList<Integer>();

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

Node<Integer> n = myList.get(Integer.valueOf(1));

System.out.println(myList.removeAfter(n));

myList.printList();

System.out.println(myList.get(Integer.valueOf(123)));

System.out.println(myList.indexOf(Integer.valueOf(123)));
    }
}