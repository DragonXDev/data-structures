package HashTables.DoubleHashing;

public class MyHashTable {
    private Computer[] table;
    private int length;
    private int N;

    public MyHashTable(int length) {
        this.length = length;
        table = new Computer[length];
        for (int i = 0; i < length; i++) {
            table[i] = null;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (isPrime(i)) {
                N = i;
                break;
            }
            if (i == 0) {
                N = 7;
                break;
            }
        }
    }

    public MyHashTable() {
        this(16);
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int hashOne(int key) {
        return key % length;
    }

    public int hashTwo(int key) {
        return N - key % N;
    }

    public int hash(int key, int i) {
        return (hashOne(key) + i * hashTwo(key)) % length;
    }

    public void insert(Computer value) {
        int bucket = hash(value.getKey(), 0);
        int curr = bucket;
        int i = 0;
        do {
            if (table[curr] == null || (table[curr].getKey() == -1)) {
                table[curr] = value;
                return;
            }
            i++;
            curr = hash(value.getKey(), i);

        } while (curr != bucket);
    }

    public int findIndex(int key) {
        int bucket = hash(key, 0);
        int curr = bucket;
        int i = 0;
        do {
            if (table[curr] == null) {
                return -1;
            }
            if (table[curr].getKey() == key) {
                return curr;
            }
            i++;
            curr = hash(key, i);

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