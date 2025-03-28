package HashTables.BasicHash;

public class MyHashTable {
    private int[] table;
    private int length;

    public MyHashTable(int length) {
        this.length = length;
        table = new int[length];
        for (int i = 0; i < length; i++) {
            table[i] = -1;
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
        if (table[index] == element) {
            return index;
        }
        return -1;
    }

    public void insert(int element) {
        int index = hash(element);
        if (table[index] == -1) {
            table[index] = element;
        } else {
            System.out.println("Collision in bucket " + index + "!");
        }
    }

    public void remove(int element) {
        int index = find(element);
        if (index != -1) {
            table[index] = -1;
        } else {
            System.out.println(element + " was not found!");
        }
    }
}