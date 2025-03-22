package Lists.DIYs.LinkedList4;

public class Node <T>{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data){
        this.data = data;
    }

    public void setNext(Node<T> n){
        next = n;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setPrevious(Node<T> p){
        previous = p;
    }

    public Node<T> getPrevious(){
        return previous;
    }

    public T getData(){
        return data;
    }

    public String toString(){
        return data+"";
    }
}