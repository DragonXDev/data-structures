package Trees.AVLTree;

import java.util.Scanner;

class AVLTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MyAVLTree<Integer> tree = new MyAVLTree<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(
                    "1. Insert a new element\n" +
                            "2. Remove an element\n" +
                            "3. Find an element\n" +
                            "4. Display nodes in order\n" +
                            "5. Print tree height\n" +
                            "6. Quit\n");
            int op = scanner.nextInt();
            if (op == 6) {
                return;
            }
            int key;
            switch (op) {
                case 1:
                    System.out.print("Enter key: ");
                    key = scanner.nextInt();
                    tree.insert(new Node<Integer>(key));
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    key = scanner.nextInt();
                    tree.remove(key);
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    key = scanner.nextInt();
                    Node<Integer> found = tree.search(key);
                    if (found != null) {
                        System.out.println(key + " was found.");
                        break;
                    }
                    System.out.println(key + " was not found.");
                    break;
                case 4:
                    System.out.println(tree);
                    break;
                case 5:
                    System.out.println("The tree has a height of " + tree.getHeight());
                    break;
            }
        }
    }
}