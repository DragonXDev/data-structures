package Trees.InOrderPrinting;

import java.util.*;

class BSTTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();

        // testExample();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Insert a new element\n" +
                            "2. Remove an element\n" +
                            "3. Find an element\n" +
                            "4. Display nodes in order\n" +
                            "5. Print tree height\n" +
                            "6. Quit");

            int op = scanner.nextInt();
            if (op == 6) {
                return;
            }
            int key = -1;
            if (op != 4 && op != 5) {
                System.out.print("Enter key: ");
                key = scanner.nextInt();
            }

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
                case 4:
                    tree.treePrint();
                    break;
                case 5:
                    System.out.println("The tree has a height of " + tree.treeHeight());
                    break;
            }

        }
    }
}
