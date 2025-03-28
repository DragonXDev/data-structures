package HashTables.Chaining;

public class MyHashTable {
    private MyLinkedList[] table;
    private int length;

    public MyHashTable(int length) {
        this.length = length;
        table = new MyLinkedList[length];
        for (int i = 0; i < length; i++) {
            table[i] = new MyLinkedList();
        }
    }

    public MyHashTable() {
        this(16);
    }

    public int hash(int key) {
        return key % length;
    }

    public int find(int element) {
        int index = hash(element);
        if (table[index].search(element)) {
            return index;
        }
        return -1;
    }

    public void insert(int element) {
        int index = hash(element);
        table[index].add(element);
    }

    public void remove(int element) {
        int index = find(element);
        if (index != -1) {
            table[index].remove(element);
        } else {
            System.out.println(element + " was not found!");
        }
    }
}