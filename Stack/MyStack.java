package Stack;

public class MyStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> dummy;
    private int size;

    public MyStack(){
        dummy = new Node<T>(null);
        dummy.setNext(null);
        dummy.setPrev(null);
        head = dummy;
        tail = dummy;
        size = 0;
    }

    public void push(T data){
        Node newNode = new Node<T>(data);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }

    public T pop(){
        if (size!=0){
            Node<T> oldTail = tail;
            oldTail.getPrev().setNext(null);
            tail = oldTail.getPrev();
            oldTail.setPrev(null);
            size--;
            return oldTail.getData();
        }
        else{
            return null;
        }
    }

    public T peek(){
        return tail.getData();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }
}