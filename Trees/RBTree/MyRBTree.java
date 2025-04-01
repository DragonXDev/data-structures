package Trees.RBTree;

import java.text.MessageFormat;

class MyRBTree<T extends Comparable<T>> {
    Node<T> root;

    public void rotateRight(Node<T> n) {
        System.out.println("Rotating Right at " + n);
        Node<T> leftChild = n.getLeft();
        Node<T> leftRightChild = leftChild.getRight();
        Node<T> parent = n.getParent();

        if (parent == null) {
            root = leftChild;
            leftChild.setParent(null);
        } else {
            parent.replaceChild(n, leftChild);
        }

        leftChild.setRight(n);
        n.setLeft(leftRightChild);
    }

    public void rotateLeft(Node<T> n) {
        System.out.println("Rotating Left at " + n);
        Node<T> rightChild = n.getRight();
        Node<T> rightLeftChild = rightChild.getLeft();
        Node<T> parent = n.getParent();

        if (parent == null) {
            root = rightChild;
            rightChild.setParent(null);
        } else {
            parent.replaceChild(n, rightChild);
        }

        rightChild.setLeft(n);
        n.setRight(rightLeftChild);
    }

    private Node<T> searchInner(Node<T> cur, T key) {
        if (cur == null)
            return null;
        if (cur.getData().compareTo(key) == 0)
            return cur;

        Node<T> found = searchInner(cur.getLeft(), key);
        if (found != null)
            return found;
        return searchInner(cur.getRight(), key);
    }

    public Node<T> search(T key) {
        return searchInner(root, key);
    }

    private boolean case1(Node<T> removeNode) {
        // debug();
        if (!removeNode.getBlack() || removeNode.getParent() == null) {
            System.out.println("Case One met!");
            return true;
        }
        return false;
    }

    private boolean case2(Node<T> removeNode, Node<T> sibling) {
        // debug();
        if (!sibling.getBlack()) {
            System.out.println("Case Two met!");
            removeNode.getParent().setBlack(false);
            sibling.setBlack(true);
            if (removeNode == removeNode.getParent().getLeft()) {
                rotateLeft(removeNode.getParent());
            } else {
                rotateRight(removeNode.getParent());
            }
            // debug();
            return true;
        }
        return false;
    }

    private boolean case3(Node<T> removeNode, Node<T> sibling) {
        // debug();
        if (removeNode.getParent().getBlack() && sibling.bothChildrenBlack()) {
            System.out.println("Case Three met!");
            sibling.setBlack(false);
            prepareForRemoval(removeNode.getParent());
            // debug();
            return true;
        }
        return false;
    }

    private boolean case4(Node<T> removeNode, Node<T> sibling) {
        // debug();
        if (!removeNode.getParent().getBlack() && sibling.bothChildrenBlack()) {
            System.out.println("Case Four met!");
            removeNode.getParent().setBlack(true);
            sibling.setBlack(false);
            // debug();
            return true;
        }
        return false;
    }

    private boolean case5(Node<T> removeNode, Node<T> sibling) {
        // debug();
        if (isNonNullAndRed(sibling.getLeft()) && isNullOrBlack(sibling.getRight())
                && removeNode == removeNode.getParent().getLeft()) {
            System.out.println("Case Five met!");
            sibling.setBlack(false);
            sibling.getLeft().setBlack(true);
            rotateRight(sibling);
            // debug();
            return true;
        }
        return false;
    }

    private boolean case6(Node<T> removeNode, Node<T> sibling) {
        // debug();
        if (isNullOrBlack(sibling.getLeft()) && isNonNullAndRed(sibling.getRight())
                && removeNode == removeNode.getParent().getRight()) {
            System.out.println("Case Six met!");
            sibling.setBlack(false);
            sibling.getRight().setBlack(true);
            rotateLeft(sibling);
            // debug();
            return true;
        }
        return false;
    }

    private boolean isNonNullAndRed(Node<T> target) {
        if (target == null)
            return false;
        return !target.getBlack();
    }

    private boolean isNullOrBlack(Node<T> target) {
        if (target == null)
            return true;
        return target.getBlack();
    }

    public void prepareForRemoval(Node<T> removeNode) {
        if (case1(removeNode))
            return;

        Node<T> sibling = removeNode.getSibling();
        if (case2(removeNode, sibling))
            sibling = removeNode.getSibling();
        if (case3(removeNode, sibling))
            return;
        if (case4(removeNode, sibling))
            return;
        if (case5(removeNode, sibling))
            sibling = removeNode.getSibling();
        if (case6(removeNode, sibling))
            sibling = removeNode.getSibling();

        sibling.setBlack(removeNode.getParent().getBlack());
        removeNode.getParent().setBlack(true);

        if (removeNode == removeNode.getParent().getLeft()) {
            sibling.getRight().setBlack(true);
            rotateLeft(removeNode.getParent());
        } else {
            sibling.getLeft().setBlack(true);
            rotateRight(removeNode.getParent());
        }
    }

    public void rbRemove(Node<T> removeNode) {
        // If node has two children, replace its key with its in‑order successor's key.
        if (removeNode.getLeft() != null && removeNode.getRight() != null) {
            Node<T> sucNode = rbGetSuc(removeNode);
            System.out.println(MessageFormat.format(
                    "Removed {0} and replaced with {1} because it had 2 children.",
                    removeNode,
                    sucNode));
            removeNode.setData(sucNode.getData());
            rbRemove(sucNode);
            return;
        }

        if (removeNode.getBlack()) {
            prepareForRemoval(removeNode);
        }

        boolean isOnRight = removeNode.getParent() != null && removeNode.getParent().getRight() == removeNode;
        bstRemove(removeNode.getParent(), removeNode, isOnRight);

        if (root != null) {
            root.setBlack(true);
        }
    }

    public void rbRemove(T key) {
        Node<T> removeNode = search(key);
        if (removeNode == null)
            return;
        rbRemove(removeNode);
    }

    // Helper method to get the in‑order successor (leftmost node of the right
    // subtree)
    private Node<T> rbGetSuc(Node<T> node) {
        node = node.getRight();
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private void bstRemove(Node<T> par, Node<T> cur, boolean parOnRight) {
        if (cur.getLeft() != null && cur.getRight() != null) {
            Node<T> sucPar = cur;
            Node<T> suc = cur.getRight();
            boolean sucParOnRight = true; // immediate right child is the successor if no left child
            while (suc.getLeft() != null) {
                sucParOnRight = false; // moving left: successor is a left child
                sucPar = suc;
                suc = suc.getLeft();
            }

            System.out.println(MessageFormat.format(
                    "Removed {0} and replaced with {1} because it had 2 children.",
                    cur,
                    suc));

            cur.setData(suc.getData());
            bstRemove(sucPar, suc, sucParOnRight);
            return;
        }

        if (cur.getLeft() != null) {
            System.out.println(MessageFormat.format(
                    "Removed {0}. It had one left child - {1}.",
                    cur,
                    cur.getLeft()));
            if (par == null) {
                root = cur.getLeft();

                if (root != null) {
                    root.setParent(null);
                }
            } else if (parOnRight) {
                par.setRight(cur.getLeft());
            } else {
                par.setLeft(cur.getLeft());
            }
            return;
        }

        if (cur.getRight() != null) {
            System.out.println(MessageFormat.format(
                    "Removed {0}. It had one right child - {1}.",
                    cur,
                    cur.getRight()));
            if (par == null) {
                root = cur.getRight();

                if (root != null) {
                    root.setParent(null);
                }
            } else if (parOnRight) {
                par.setRight(cur.getRight());
            } else {
                par.setLeft(cur.getRight());
            }
            return;
        }

        System.out.println(MessageFormat.format("Removed {0}. It had no children.", cur));
        if (par == null) {
            root = null;
        } else if (parOnRight) {
            par.setRight(null);
        } else {
            par.setLeft(null);
        }
    }

    private int getHeightInner(Node<T> n) {
        if (n == null)
            return -1;
        int hLeft = getHeightInner(n.getLeft());
        int hRight = getHeightInner(n.getRight());
        return 1 + Math.max(hLeft, hRight);
    }

    public int getHeight() {
        return getHeightInner(root);
    }

    private String toString(Node<T> n) {
        if (n == null)
            return "";
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

    public void insert(Node<T> n) {
        if (root == null) {
            root = n;
            System.out.println("Inserted " + n + " as root!");
            redBlackInsertRebalance(n);
            // debug();
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

        redBlackInsertRebalance(n);
        // debug();
    }

    private void redBlackInsertRebalance(Node<T> n) {
        if (n == root) {
            n.setBlack(true);
            return;
        }
        if (n.getParent().getBlack()) {
            return;
        }

        Node<T> par = n.getParent();
        Node<T> unc = n.getUncle();
        Node<T> gp = n.getGrandparent();

        if (unc != null && !unc.getBlack()) {
            par.setBlack(true);
            unc.setBlack(true);
            gp.setBlack(false);
            redBlackInsertRebalance(gp);
            return;
        }

        if (par.getRight() == n && gp.getLeft() == par) {
            rotateLeft(par);
            n = par;
            par = n.getParent();
        } else if (par.getLeft() == n && gp.getRight() == par) {
            rotateRight(par);
            n = par;
            par = n.getParent();
        }

        par.setBlack(true);
        gp.setBlack(false);
        if (par.getLeft() == n) {
            rotateRight(gp);
        } else {
            rotateLeft(gp);
        }
    }

    // ---------- DEBUG

    private int NODE_LEN = 2;

    private void matricize(Node<T>[][] out, Node<T> n, int leftCount, int depth) {
        out[depth][leftCount] = n;
        if (n == null) {
            return;
        }
        depth++;
        matricize(out, n.getLeft(), leftCount * 2, depth);
        matricize(out, n.getRight(), leftCount * 2 + 1, depth);
    }

    private String padNode(Node<T> n) {
        String out = "";
        if (n == null) {
            for (int i = 0; i < NODE_LEN; i++) {
                out += " ";
            }
            return out;
        }
        int intrinsicLen = n.getData().toString().length();
        out += n.toString();
        for (int i = 0; i < NODE_LEN - intrinsicLen; i++) {
            out += " ";
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    public void debug() {
        Node<T>[][] out = new Node[getHeight() + 2][];
        for (int i = 0; i < out.length; i++) {
            out[i] = new Node[1 << i];
        }
        matricize(out, root, 0, 0);

        int maxLen = (1 << (out.length - 1)) * NODE_LEN;
        for (int i = 0; i < out.length; i++) {
            String line = "";
            int count = 1 << i;
            int sepLen = (int) Math.round(((double) maxLen - NODE_LEN * count) / count);
            int startLen = (int) Math.floor(((double) sepLen) / 2);

            for (int j = 0; j < startLen; j++) {
                line += " ";
            }
            Node<T>[] arr = out[i];
            for (int j = 0; j < arr.length; j++) {
                line += padNode(arr[j]);
                for (int k = 0; k < sepLen; k++) {
                    line += " ";
                }
            }
            System.out.println(line);
        }
    }
}
