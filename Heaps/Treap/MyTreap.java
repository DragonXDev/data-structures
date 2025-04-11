package Heaps.Treap;

import java.text.MessageFormat;

class MyTreap<T extends Comparable<T>> {
    Node<T> root;

    public void rotateRight(Node<T> newNode) {

        System.out.println("Rotating Right at " + newNode);

        Node<T> leftChild = newNode.getLeft();
        Node<T> leftRightChild = leftChild.getRight();
        Node<T> parent = newNode.getParent();
        if (parent == null) {
            root = leftChild;
            leftChild.setParent(null);
        } else {
            parent.replaceChild(newNode, leftChild);
        }
        leftChild.setRight(newNode);
        newNode.setLeft(leftRightChild);
    }

    public void rotateLeft(Node<T> newNode) {
        System.out.println("Rotating Left at " + newNode);

        Node<T> rightChild = newNode.getRight();
        Node<T> rightLeftChild = rightChild.getLeft();
        Node<T> parent = newNode.getParent();

        if (parent == null) {
            root = rightChild;
            rightChild.setParent(null);
        } else {
            parent.replaceChild(newNode, rightChild);
        }
        rightChild.setLeft(newNode);
        newNode.setRight(rightLeftChild);
    }

    private void percolateUp(Node<T> n) {
        int priority = n.getPriority();
        Node<T> parent = n.getParent();
        while (parent != null && priority > parent.getPriority()) {
            if (n == parent.getRight()) {
                rotateLeft(parent);
            } else {
                rotateRight(parent);
            }
            parent = n.getParent();
        }
    }

    private void percolateDown(Node<T> n) {
        n.setPriority(-1);
        while (n.getLeft() != null || n.getRight() != null) {
            Node<T> left = n.getLeft();
            Node<T> right = n.getRight();
            if (left == null) {
                rotateLeft(n);
            } else if (right == null) {
                rotateRight(n);
            } else if (left.getPriority() < right.getPriority()) {
                rotateLeft(n);
            } else {
                rotateRight(n);
            }
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
                    percolateUp(newNode);
                    return;
                } else {
                    cur = cur.getLeft();
                }
            }
        }
    }

    private void bstRemoveNode(Node<T> par, Node<T> cur, boolean parOnRight) {

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
            bstRemoveNode(sucPar, suc, sucParOnRight);
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

    public void bstRemove(T key) {
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

        bstRemoveNode(par, cur, parOnRight);
    }

    public void bstRemove(Node<T> n) {
        bstRemove(n.getKey());
    }

    public boolean remove(Node<T> n) {
        percolateDown(n);
        bstRemove(n);
        return true;
    }

    public Node<T> peek() {
        return root;
    }
}
