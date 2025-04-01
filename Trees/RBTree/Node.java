package Trees.RBTree;

class Node<T extends Comparable<T>> {
    private T data;
    private boolean isBlack;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public T getKey() {
        return data;
    }

    public Node<T> getSibling() {
        if (parent != null) {
            if (this == parent.getLeft()) {
                return parent.getRight();
            }
            return parent.getLeft();
        }
        return null;
    }

    public boolean bothChildrenBlack() {
        if (left != null && !left.getBlack()) {
            return false;
        }
        if (right != null && !right.getBlack()) {
            return false;
        }
        return true;
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

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        setChild(true, left);
    }

    public void setRight(Node<T> right) {
        setChild(false, right);
    }

    public boolean getBlack() {
        return isBlack;
    }

    public void setBlack(boolean isBlack) {
        this.isBlack = isBlack;
    }

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

    public Node<T> getGrandparent() {
        if (parent == null) {
            return null;
        }
        return parent.parent;
    }

    public Node<T> getUncle() {
        if (parent == null)
            return null;
        return parent.getSibling();
    }

    @Override
    public String toString() {
        String prefix = "";
        String suffix = "";
        if (!isBlack) {
            prefix = "\u001b[31m";
            suffix = "\u001b[0m";
        }
        return prefix + data.toString() + suffix;
    }
}
