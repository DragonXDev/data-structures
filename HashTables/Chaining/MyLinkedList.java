package HashTables.Chaining;

public class MyLinkedList {
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean search(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.getData() == data) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }
        tail.setNext(new Node(data));
        tail = tail.getNext();
    }

    public void remove(int data) {
        if (tail == head) {
            head = null;
            tail = null;
            return;
        }
        Node curr = head;
        while (curr != tail) {
            if (curr.getNext().getData() == data) {
                if (curr.getNext() == tail) {
                    tail = curr;
                    curr.setNext(null);
                    break;
                }
                curr.setNext(curr.getNext().getNext());
            }
            curr = curr.getNext();
        }

    }
}