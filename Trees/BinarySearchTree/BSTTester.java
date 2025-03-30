package Trees.BinarySearchTree;

import java.util.*;

class BSTTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Insert a new element\n" +
                            "2. Remove an element\n" +
                            "3. Find an element\n" +
                            "4. Quit");

            int op = scanner.nextInt();
            if (op == 4) {
                return;
            }

            System.out.print("Enter key: ");
            int key = scanner.nextInt();

            switch (op) {
                case 1:
                    tree.insert(new Node<Integer>(key));
                    break;
                case 2:
                    tree.remove(key);
                    break;
                case 3:
                    tree.search(key);
                    break;
            }

        }
    }
}
