package Trees.Parent;

class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
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

    public int compareTo(Node<T> other) {
        return this.data.compareTo(other.data);
    }

}