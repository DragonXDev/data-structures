package Stack;

public class Node<T> {
    private Node next;
    private Node prev;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setPrev(Node prev){
        this.prev = prev;
    }

    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public T getData(){
        return data;
    }
}