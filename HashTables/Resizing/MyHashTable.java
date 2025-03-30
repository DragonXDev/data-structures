package HashTables.Resizing;

public class MyHashTable {
    private int allocedSpace = 0; // Tracks the number of elements in the table
    private int allocLength; // Total length of the hash table
    private Computer[] computerArr; // Array to store Computer objects
    int N; // largest prime number below the current length

    public MyHashTable(int length) {
        computerArr = new Computer[length];
        this.N = findLargestPrime(length);
        for (int i = 0; i < length; i++) {
            computerArr[i] = null;
        }
        this.allocLength = length;
    }

    public MyHashTable() {
        computerArr = new Computer[16];
        this.N = 13;
        for (int i = 0; i < 16; i++) {
            computerArr[i] = null;
        }
        this.allocLength = 16;
    }

    public void resize() {
        int oldLength = allocLength;
        this.allocLength = allocLength * 2;
        Computer[] arrCpy = computerArr;
        computerArr = new Computer[this.allocLength];
        for (int i = 0; i < oldLength; i++) {
            if (arrCpy[i] == null || arrCpy[i].getOs() == "") {
                continue;
            } else {
                insert(arrCpy[i]);
            }
        }
        System.out.print("Resized to " + allocLength);
    }

    public int findLargestPrime(int length) {
        for (int i = length; i >= 0; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1; // case should never be met
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int hashOne(int key) {
        return key % allocLength;
    }

    public int hashTwo(int key) {
        return N - key % N;
    }

    public int hash(int key, int i) {
        return (hashOne(key) + i * hashTwo(key)) % allocLength;
    }

    public int find(int key) {
        return findIndex(key);
    }

    public void insert(Computer c) {
        int i = 0; // probing increament
        int collisionCount = 0;
        int key = c.getSerialNumber();
        int h;
        double loadFactor = ((double) allocedSpace) / ((double) allocLength);
        if (loadFactor >= 0.6) {
            resize();
        }
        while (true) {
            h = hash(key, i);

            if (computerArr[h] == null || computerArr[h].getOs().equals("")) {
                computerArr[h] = c;
                allocedSpace++;
                break;
            }
            i++;
            collisionCount++;
            if (collisionCount == 4) {
                resize();
                i = 0;
                collisionCount = 0;
            }
        }
    }

    public int findIndex(int key) {
        int h;
        int i = 0;

        while (i < allocLength) {
            h = hash(key, i);

            if (computerArr[h] == null) {
                return -1; // Key not found
            }

            if (computerArr[h].getKey() == key) {
                return h; // Key found
            }
            i++;
        }

        return -1; // Key not found after full table traversal
    }

    public Computer get(int key) {
        int idx = findIndex(key);
        return idx == -1 ? null : computerArr[idx];
    }

    public Computer remove(int key) {
        int idx = findIndex(key);
        if (idx == -1) {
            return null;
        }
        Computer temp = computerArr[idx];
        computerArr[idx] = new Computer();
        allocedSpace--;
        return temp;
    }
}