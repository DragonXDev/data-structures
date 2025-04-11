package Heaps.Treap;

class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private int priority;

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        priority = (int) (Math.random() * 100) + 1;
    }

    public Node(T data) {
        this(data, null, null);
    }

    public T getKey() {
        return data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public int getPriority() {
        return priority;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int compareTo(Node<T> other) {
        return this.data.compareTo(other.data);
    }

    public void addChild(boolean isLeft, Node<T> newChild) {
        if (isLeft) {
            this.left = newChild;
        } else {
            this.right = newChild;
        }
        if (newChild != null) {
            newChild.parent = this;
        }
    }

    public boolean replaceChild(Node<T> oldChild, Node<T> newChild) {
        if (left == oldChild) {
            addChild(true, newChild);
            return true;
        }
        if (right == oldChild) {
            addChild(false, newChild);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return data.toString() + "(" + priority + ")";
    }

}