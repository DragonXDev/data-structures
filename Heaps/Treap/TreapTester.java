package Heaps.Treap;

import java.util.Scanner;

public class TreapTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MyTreap<String> treap = new MyTreap<String>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Insert a new value\n" +
                            "2. Remove a value\n" +
                            "3. Peek at the top\n" +
                            "4. Quit");
            int op = scanner.nextInt();
            if (op == 4) {
                return;
            }
            switch (op) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter the new value: ");
                    String value = scanner.nextLine();
                    treap.insert(new Node<String>(value));
                    break;
                case 2:
                    String removed = treap.peek().getKey();
                    treap.remove(treap.peek());
                    System.out.println("Removed " + removed);
                    break;
                case 3:
                    String peeked = treap.peek().getKey();
                    if (peeked == null) {
                        System.out.println("Empty!");
                        break;
                    }
                    System.out.println(peeked);
                    break;
            }
        }
    }
}
