package Trees.Parent;

import java.text.MessageFormat;

class MyBinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public void inorderPrint(Node<T> n) {
        if (n == null)
            return;

        inorderPrint(n.getLeft());
        System.out.print(n.getData() + " ");
        inorderPrint(n.getRight());
    }

    public void treePrint() {
        inorderPrint(root);
    }

    public int treeHeight(Node<T> n) {
        if (n == null) {
            return -1;
        }
        int leftHeight = treeHeight(n.getLeft());
        int rightHeight = treeHeight(n.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int treeHeight() {
        return treeHeight(root);
    }

    public int calculateHeight(Node<T> n) {
        if (n == null) {
            return -1;
        }
        Node<T> cur = root;
        int height = 0;
        while (cur != null) {
            int comp = n.getData().compareTo(cur.getData());
            if (comp == 0) {
                return height;
            }
            if (comp < 0) {
                cur = cur.getLeft();
                height++;
                continue;
            }
            cur = cur.getRight();
            height++;
        }
        return -1;

    }

    public Node<T> search(T key, Node<T> curr) {
        if (curr == null) {
            return null;
        }
        if (curr.getData().equals(key)) {
            return curr;
        }

        Node<T> left = search(key, curr.getLeft());
        Node<T> right = search(key, curr.getRight());
        return left == null ? right : left;
    }

    public void search(T key) {
        Node<T> found = search(key, root);
        if (found != null) {
            System.out.println(MessageFormat.format("{0} was found.", key));
        } else {
            System.out.println(MessageFormat.format("{0} was not found!", key));
        }
    }

    public void insert(Node<T> newNode) {
        Node<T> cur = root;
        if (root == null) {
            System.out.println(MessageFormat.format("Inserted {0} as root!", newNode.getData()));
            root = newNode;
            return;
        }
        while (cur != null) {
            if (newNode.getData().compareTo(cur.getData()) >= 0) {
                if (cur.getRight() == null) {
                    System.out.println(MessageFormat.format(
                            "{0} was inserted to the right of {1}",
                            newNode.getData(),
                            cur.getData()));
                    cur.setRight(newNode);
                    return;
                } else {
                    cur = cur.getRight();
                }
            } else {
                if (cur.getLeft() == null) {
                    System.out.println(MessageFormat.format(
                            "{0} was inserted to the left of {1}",
                            newNode.getData(),
                            cur.getData()));
                    cur.setLeft(newNode);
                    return;
                } else {
                    cur = cur.getLeft();
                }
            }
        }
    }

    private void removeNode(Node<T> par, Node<T> cur, boolean parOnRight) {
        // 2 children
        if (cur.getLeft() != null && cur.getRight() != null) {
            Node<T> sucPar = cur;
            Node<T> suc = cur.getRight();
            boolean sucParOnRight = false;
            while (suc.getLeft() != null) {
                sucParOnRight = true;
                sucPar = suc;
                suc = suc.getLeft();
            }

            System.out.println(MessageFormat.format(
                    "Removed {0} and replaced with {1} because it had 2 children.",
                    cur.getData(),
                    suc.getData()));

            cur.setData(suc.getData());
            removeNode(sucPar, suc, sucParOnRight);
            return;
        }

        if (cur.getLeft() != null) {
            System.out.println(MessageFormat.format(
                    "Removed {0}. It had one left child - {1}.",
                    cur.getData(),
                    cur.getLeft().getData()));

            if (par == null) {
                root = cur.getLeft();
            }
            if (parOnRight) {
                par.setLeft(cur.getLeft());
                return;
            }
            par.setRight(cur.getLeft());
            return;
        }
        if (cur.getRight() != null) {
            System.out.println(MessageFormat.format(
                    "Removed {0}. It had one right child - {1}.",
                    cur.getData(),
                    cur.getRight().getData()));

            if (par == null) {
                root = cur.getRight();
            }
            if (parOnRight) {
                par.setLeft(cur.getRight());
                return;
            }
            par.setRight(cur.getRight());
            return;
        }

        System.out.println(MessageFormat.format(
                "Removed {0}. It had no children.",
                cur.getData()));

        if (par == null) {
            root = null;
        }
        if (parOnRight) {
            par.setLeft(null);
            return;
        }
        par.setRight(null);
    }

    public void remove(T key) {
        Node<T> par = null;
        Node<T> cur = root;

        if (cur == null) {
            return;
        }

        boolean parOnRight = false;
        while (cur != null) {
            int comp = key.compareTo(cur.getData());
            if (comp > 0) {
                par = cur;
                cur = cur.getRight();
                parOnRight = false;
                continue;
            }
            if (comp < 0) {
                par = cur;
                cur = cur.getLeft();
                parOnRight = true;
                continue;
            }
            break;
        }

        removeNode(par, cur, parOnRight);
    }

    public void remove(Node<T> n) {
        remove(n.getKey());
    }
}
