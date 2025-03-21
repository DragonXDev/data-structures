package Lists.DIYs.LinkedList2;

public class MySLinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MySLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public Node<T> get(int index){
        if(index+1==0){
            return null;
        }
        else if(index+1<0){
            System.out.println("That is an invalid index!");
        }

        Node<T> finalVal = head;
        for(int i = 0; i < index; i++){
            finalVal = finalVal.getNext();
        }
        return finalVal;
    }

    public void append(T a){
        Node<T> n = new Node<T>(a);
        if(head!=null){
            tail.setNext(n);
        }
        else{
            head = n;
        }
        tail = n;
        size++;
    }

    public void prepend(T a){
        Node<T> n = new Node<T>(a);
        if(head!=null){
            n.setNext(head);
        }
        head = n;
        size++;
    }

    public void insertAfter(Node<T> before, T a){
        Node<T> newNode = new Node<T>(a);
        if(before==null){
            newNode.setNext(head);
            head = newNode;
            if(size==0){
                tail = newNode;
            }
        }
        else if(tail == before){
            before.setNext(newNode);
            tail = newNode;
        }
        else{
            newNode.setNext(before.getNext());
            before.setNext(newNode);
        }
        size++;
    }

    public void insert(int index, T value){
        if(index>size){
            System.out.println("That is an invalid index!");
            return;
        }
        Node<T> n = get(index-1);
        insertAfter(n, value);
    }

    public void printList(){
        Node<T> curr = head;
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