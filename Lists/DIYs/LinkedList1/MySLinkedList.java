package Lists.DIYs.LinkedList1;

public class MySLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MySLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index){
        if(index+1>size){
            System.out.println("That is an invalid index!");
            return -1;
        }

        Node finalVal = head;
        for(int i = 0; i < index; i++){
            finalVal = finalVal.getNext();
        }
        return finalVal.getData();
    }

    public void append(int a){
        Node n = new Node(a);
        if(head!=null){
            tail.setNext(n);
        }
        else{
            head = n;
        }
        tail = n;
        size++;
    }

    public void prepend(int a){
        Node n = new Node(a);
        if(head!=null){
            n.setNext(head);
        }
        head = n;
        size++;
    }

    public void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    
}