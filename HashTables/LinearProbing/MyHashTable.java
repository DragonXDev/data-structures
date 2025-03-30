package HashTables.LinearProbing;

public class MyHashTable {
    private Computer[] table;
    private int length;

    public MyHashTable(int length) {
        this.length = length;
        table = new Computer[length];
        for (int i = 0; i < length; i++) {
            table[i] = null;
        }
    }

    public MyHashTable() {
        this.length = 16;
        table = new Computer[length];
        for (int i = 0; i < length; i++) {
            table[i] = null;
        }
    }

    public int hash(int key) {
        return key % length;
    }

    public void insert(Computer value) {
        int bucket = hash(value.getKey());
        int curr = bucket;
        do {
            if (table[curr] == null || (table[curr].getKey() == -1)) {
                table[curr] = value;
                return;
            }
            curr += 1;
            curr %= length;

        } while (curr != bucket);
    }

    public int findIndex(int key) {
        int bucket = hash(key);
        int curr = bucket;
        do {
            if (table[curr] == null) {
                return -1;
            }
            if (table[curr].getKey() == key) {
                return curr;
            }
            curr += 1;
            curr %= length;

        } while (curr != bucket);
        return -1;
    }

    public int find(int key) {
        return findIndex(key);
    }

    public Computer get(int key) {
        int n = findIndex(key);
        return n != -1 ? table[n] : null;
    }

    public Computer remove(int key) {
        int index = findIndex(key);
        Computer removal = get(key);
        if (index == -1) {
            return null;
        }
        table[index] = new Computer();
        return removal;

    }
}