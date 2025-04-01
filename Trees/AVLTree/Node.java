package Trees.AVLTree;

class Node<T extends Comparable<T>> {
    private int height;
    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public T getKey() {
        return data;
    }

    public void updateHeight() {
        int lHeight = left == null ? -1 : left.height;
        int rHeight = right == null ? -1 : right.height;
        height = 1 + (lHeight > rHeight ? lHeight : rHeight);
    }

    public int getBalance() {
        int lHeight = left == null ? -1 : left.height;
        int rHeight = right == null ? -1 : right.height;
        return lHeight - rHeight;
    }

    public void setChild(boolean isLeft, Node<T> newChild) {
        if (isLeft) {
            this.left = newChild;
        } else {
            this.right = newChild;
        }
        if (newChild != null) {
            newChild.parent = this;
        }
        updateHeight();
    }

    public void setLeft(Node<T> left) {
        this.setChild(true, left);
    }

    public void setRight(Node<T> right) {
        this.setChild(false, right);
    }

    public boolean replaceChild(Node<T> oldChild, Node<T> newChild) {
        if (left == oldChild) {
            setChild(true, newChild);
            return true;
        }
        if (right == oldChild) {
            setChild(false, newChild);
            return true;
        }
        return false;
    }

    public Node(T data) {
        this.data = data;
        this.height = 0;
    }

    @Override
    public String toString() {
        return data.toString() + "(" + height + ")";
    }
}