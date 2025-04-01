package Trees.RBTree;

import java.util.Scanner;

class RBTreeTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MyRBTree<Integer> tree = new MyRBTree<Integer>();
        Scanner scanner = new Scanner(System.in);

        Node<Integer> remembered = null;

        while (true) {
            System.out.print(
                    "1. Insert a new element\n" +
                            "2. Find an element\n" +
                            "3. Remove a Node\n" +
                            "4. Print Remembered Node's Family\n" +
                            "5. Display nodes in order\n" +
                            "6. Print tree height\n" +
                            "7. Quit\n");
            int op = scanner.nextInt();
            if (op == 7) {
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
                    remembered = tree.search(key);
                    if (remembered != null) {
                        System.out.println(remembered + " was found.");
                    } else {
                        System.out.println(key + " was not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    key = scanner.nextInt();
                    Node<Integer> found = tree.search(key);
                    if (found == null) {
                        System.out.println(key + " was not found in the Tree!");
                    } else {
                        tree.rbRemove(key);
                        System.out.println(key + " was successfully removed!");
                    }
                    break;
                case 4:
                    if (remembered == null) {
                        System.out.println("Remembered Node is null");
                        break;
                    }
                    System.out.println(remembered + "'s parent is " + remembered.getParent());
                    System.out.println(remembered + "'s grandparent is " + remembered.getGrandparent());
                    System.out.println(remembered + "'s uncle is " + remembered.getUncle());
                    System.out.println(remembered + "'s sibling is " + remembered.getSibling());
                    System.out.println(remembered + "'s left child is " + remembered.getLeft());
                    System.out.println(remembered + "'s right child is " + remembered.getRight());
                    break;
                case 5:
                    System.out.println(tree);
                    break;
                case 6:
                    System.out.println("The tree has a height of " + tree.getHeight());
                    break;
            }
        }
    }
}
