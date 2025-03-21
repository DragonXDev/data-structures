package Lists.DIYs.LinkedList1;

public class Node {
    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
    }

    public void setNext(Node n){
        next = n;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }
}