package Trees.AVLTree;

class MyAVLTree<T extends Comparable<T>> {
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

    public void treeRebalance(Node<T> cur) {
        cur.updateHeight();
        if (cur.getBalance() == -2) {
            if (cur.getRight().getBalance() == 1) {
                rotateRight(cur.getRight());
            }
            rotateLeft(cur);
        } else if (cur.getBalance() == 2) {
            if (cur.getLeft().getBalance() == -1) {
                rotateLeft(cur.getLeft());
            }
            rotateRight(cur);
        }
    }

    private Node<T> searchRecur(Node<T> cur, T key) {
        if (cur == null) {
            return null;
        }
        if (cur.getData() == key) {
            return cur;
        }
        Node<T> found = searchRecur(cur.getLeft(), key);
        if (found != null) {
            return found;
        }
        found = searchRecur(cur.getRight(), key);
        if (found != null) {
            return found;
        }
        return null;

    }

    public Node<T> search(T key) {
        return searchRecur(root, key);
    }

    public void insert(Node<T> n) {
        if (root == null) {
            root = n;
            System.out.println("Inserted " + n + " as root!");
            return;
        }
        Node<T> target = root;
        while (true) {
            if (n.getData().compareTo(target.getData()) >= 0) {
                if (target.getRight() == null) {
                    target.setRight(n);
                    System.out.println(n + " was inserted to the right of " + target);
                    break;
                } else {
                    target = target.getRight();
                }
                continue;
            }
            if (target.getLeft() == null) {
                target.setLeft(n);
                System.out.println(n + " was inserted to the left of " + target);
                break;
            }
            target = target.getLeft();
        }
        while (target != null) {
            treeRebalance(target);
            target = target.getParent();
        }
    }

    public boolean remove(Node<T> n) {
        if (n == null) {
            return false;
        }
        Node<T> parent = n.getParent();

        if (n.getLeft() != null && n.getRight() != null) {
            Node<T> suc = n.getRight();
            while (suc.getLeft() != null) {
                suc = suc.getLeft();
            }
            System.out.println("Removed " + n + " and replaced with " + suc + " because it had 2 children.");
            n.setData(suc.getData());
            remove(suc);
        } else if (n.getLeft() != null) {
            System.out.println("Removed " + n + ". It had one left child - " + n.getLeft() + ".");
            n.setData(n.getLeft().getData());
            n.setLeft(null);
        } else if (n.getRight() != null) {
            System.out.println("Removed " + n + ". It had one right child - " + n.getRight() + ".");
            n.setData(n.getRight().getData());
            n.setRight(null);
        } else {
            parent.replaceChild(n, null);
            System.out.println("Removed " + n + ". It had no children.");
        }

        while (parent != null) {
            treeRebalance(parent);
            parent = parent.getParent();
        }

        return true;
    }

    public boolean remove(T key) {
        return remove(search(key));
    }

    private String toString(Node<T> n) {
        if (n == null) {
            return "";
        }
        String out = "";
        if (n.getLeft() != null) {
            out += toString(n.getLeft()) + " ";
        }
        out += n.toString();
        if (n.getRight() != null) {
            out += " " + toString(n.getRight());
        }
        return out;
    }

    public String toString() {
        return toString(root) + " ";
    }

    public int getHeight() {
        return root.getHeight();
    }
}
