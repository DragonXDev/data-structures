package Lists.DoubleLinkedList;

public class MyDLinkedList < T extends Comparable<T> > {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> dummy;
    private int size;

    public MyDLinkedList() {
        dummy = new Node<T>(null);
        dummy.setNext(null);
        dummy.setPrevious(null);
        head = dummy;
        tail = dummy;
        size = 0;
    }

    public Node<T> get(int index) {
        if (index + 1 == 0) {
            return head;
        } else if (index + 1 < 0) {
            return head;
        }

        Node<T> finalVal = head.getNext();
        for (int i = 0; i < index; i++) {
            finalVal = finalVal.getNext();
        }
        return finalVal;
    }

    public Node<T> get(T value) {

        Node<T> finalVal = head;
        while (finalVal != null) {
            if (finalVal.getData() == value) {
                return finalVal;
            }
            finalVal = finalVal.getNext();
        }
        System.out.println("That value was not found!");
        return null;
    }

    public int indexOf(T value) {

        Node<T> finalVal = head;
        int idx = 0;
        while (finalVal != null) {
            if (finalVal.getData() == value) {
                return idx;
            }
            finalVal = finalVal.getNext();
            idx++;
        }
        System.out.println("That value was not found!");
        return -1;
    }

    public Node<T> removeAfter(Node<T> before) {
        Node<T> rem = before.getNext();
        if(rem==null){
            return null;
        }

        before.setNext(rem.getNext());
        if(rem.getNext()!=null){
            rem.getNext().setPrevious(before);
        }
        size--;
        return rem;
    }

    public Node<T> remove(Node<T> rem) {
        removeAfter(rem.getPrevious());
        rem.setNext(null);
        rem.setPrevious(null);
        return rem;
    }

    public Node<T> remove(int index) {
        Node<T> prev = get(index - 1);
        Node<T> removed = removeAfter(prev);
        return removed;
    }

    public Node<T> remove(T value) {
        Node<T> prev = get(indexOf(value) - 1);
        Node<T> removed = removeAfter(prev);
        return removed;
    }

    public void append(T a) {
        Node<T> n = new Node<T>(a);
        tail.setNext(n);
        n.setPrevious(tail);
        size++;
        tail = n;
    }

    public void prepend(T a) {
        insertAfter(head,a);
    }

    public void insertAfter(Node<T> before, T a) {
        Node<T> n = new Node<T>(a);
        n.setPrevious(before);
        n.setNext(before.getNext());
        if (tail != before && before.getNext()!=null) {
            before.getNext().setPrevious(n);
        } else {
            tail = n;
        }
        before.setNext(n);
        size++;
    }

    public void insert(int index, T value) {
        if (index >= size+1) {
            System.out.println("That is an invalid index!");
            return;
        }
        Node<T> n = get(index-1);
        insertAfter(n, value);
    }

    public void printList() {
        Node<T> curr = head.getNext();
        while (curr != null) {
            System.out.print(curr.getData());
            curr = curr.getNext();
        }
        System.out.println();
    }

    public void printListBackward() {
        Node<T> curr = tail;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getPrevious();
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public MyDLinkedList<T> split() {
        int mid = size / 2;
        Node<T> midPos = get(mid);
        Node<T> curr = get(mid);
        MyDLinkedList<T> rightSide = new MyDLinkedList<T>();
        for (Node<T> n = curr; n != null; n = n.getNext()) {
            rightSide.append(n.getData());
        }
        size = mid;
        if (midPos != null) {
            midPos.getPrevious().setNext(null);
            tail = midPos.getPrevious();
        } else {
            tail = null;
            return null;
        }
        return rightSide;
    }

    public MyDLinkedList<T> merge(MyDLinkedList<T> right) {
        MyDLinkedList<T> merged = new MyDLinkedList<T>();
        Node<T> curr = head.getNext();
        Node<T> headRight = right.head.getNext();
        while (curr != null || headRight != null) {
            if (headRight == null) {
                merged.append(curr.getData());
                curr = curr.getNext();
            } else if (curr == null) {
                merged.append(headRight.getData());
                headRight = headRight.getNext();
            } else {
                if (curr.compareTo(headRight) < 0) {
                    merged.append(curr.getData());
                    curr = curr.getNext();
                } else {
                    merged.append(headRight.getData());
                    headRight = headRight.getNext();
                }
            }
        }
        return merged;

    }

    public void mergeSort() {
        if (this.size <= 1) {
            return;
        }
        MyDLinkedList<T> right = split();
        this.mergeSort();
        right.mergeSort();
        MyDLinkedList<T> merged = merge(right);
        this.head = merged.head;
        this.tail = merged.tail;
        this.size = merged.size;

    }
}