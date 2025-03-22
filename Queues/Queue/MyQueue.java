package Queues.Queue;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> dummy;
    private int size;

    public MyQueue(){
        dummy = new Node<T>(null);
        dummy.setNext(null);
        dummy.setPrev(null);
        head = dummy;
        tail = dummy;
        size = 0;
    }

    public void enqueue(T data){
        Node newNode = new Node<T>(data);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }

        Node<T> returnNode = head.getNext();
        head.setNext(returnNode.getNext());

        if (returnNode.getNext() != null) {
            returnNode.getNext().setPrev(head);
        } else {
            tail = head;
        }

        size--;

        return returnNode.getData();
    }


    public T peek(){
        if(size!=0){
            return head.getNext().getData();
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }
}