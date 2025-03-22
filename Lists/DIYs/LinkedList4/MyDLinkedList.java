package Lists.DIYs.LinkedList4;

public class MyDLinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDLinkedList(){
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

    public Node<T> get(T value){

        Node<T> finalVal = head;
        while(finalVal!=null){
            if(finalVal.getData()==value){
                return finalVal;
            }
            finalVal = finalVal.getNext();
        }
        System.out.println("That value was not found!");
        return null;
    }

    public int indexOf(T value){

        Node<T> finalVal = head;
        int idx = 0;
        while(finalVal!=null){
            if(finalVal.getData()==value){
                return idx;
            }
            finalVal = finalVal.getNext();
            idx++;
        }
        System.out.println("That value was not found!");
        return -1;
    }

    public Node<T> removeAfter(Node<T> before){
        Node<T> curr;
        if(before==null){
            curr = head;
            head = curr.getNext();
            curr.getNext().setPrevious(null);
            curr.setNext(null);

        }
        else if(before.getNext()==null){
            return null;
        }
        else{
            curr = before.getNext();
            before.setNext(curr.getNext());
            curr.getNext().setPrevious(before);

        }
        if(curr.getNext()==null){
            tail = before;
        }
        else{
            curr.setNext(null);
        }
        return curr;
    }

    public Node<T> remove(Node<T> rem){
        removeAfter(rem.getPrevious());
        rem.setNext(null);
        rem.setPrevious(null);
        return rem;
    }

    public Node<T> remove(int index){
        Node<T> prev = get(index-1);
        Node<T> removed = removeAfter(prev);
        return removed;
    }

    public Node<T> remove(T value){
        Node<T> prev = get(indexOf(value)-1);
        Node<T> removed = removeAfter(prev);
        return removed;
    }

    public void append(T a){
        Node<T> n = new Node<T>(a);
        if(head!=null){
            tail.setNext(n);
            n.setPrevious(tail);
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
            head.setPrevious(n);
        }
        head = n;
        size++;
    }

    public void insertAfter(Node<T> before, T a){
        Node<T> newNode = new Node<T>(a);
        if(before==null){
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
            if(size==0){
                tail = newNode;
            }
        }
        else if(tail == before){
            before.setNext(newNode);
            newNode.setPrevious(before);
            tail = newNode;
        }
        else{
            newNode.setNext(before.getNext());
            before.getNext().setPrevious(newNode);
            before.setNext(newNode);
            newNode.setPrevious(before);
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

    public void printListBackward(){
        Node<T> curr = tail;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr = curr.getPrevious();
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    
}