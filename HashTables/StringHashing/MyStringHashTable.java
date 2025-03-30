package HashTables.StringHashing;

import java.util.*;

public class MyStringHashTable {
    private String[] arr;
    private String removalEmpty = "\0";
    private int primeN;
    private int inserted;

    MyStringHashTable() {
        this.arr = new String[16];
        this.primeN = this.highestPrimeUnder(16);
    }

    MyStringHashTable(int length) {
        if (length < 0) {
            this.arr = new String[16];
            this.primeN = this.highestPrimeUnder(16);
            return;
        }
        this.arr = new String[length];
        this.primeN = this.highestPrimeUnder(length);
    }

    int highestPrimeUnder(int n) {
        ArrayList<Integer> found = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int prime : found) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                found.add(i);
            }
        }
        return found.get(found.size() - 1);
    }

    public int hash(String key, int i) {
        return (hashOne(key) + i * hashTwo(key)) % arr.length;
    }

    public int hashOne(String key) {
        int val = 5381;
        int multiplier = 33;
        for (int i = 0; i < key.length(); i++) {
            int c = key.charAt(i);
            val *= multiplier;
            val += c;
        }
        return val % arr.length;
    }

    public int hashTwo(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            int c = key.charAt(i);
            sum += c;
        }
        return arr.length - sum % arr.length;
    }

    public void insert(String comp) {
        comp = comp.toUpperCase();

        double load = ((double) inserted + 1) / arr.length;
        if (load > 0.6) {
            resize();
            insert(comp);
            return;
        }

        int start = hashOne(comp);
        int i = 0;
        int offset = hashTwo(comp);
        while (i < arr.length) {
            if (i >= 4) {
                resize();
                insert(comp);
                return;
            }
            int idx = (start + i * offset) % arr.length;
            if (this.arr[idx] == null || this.arr[idx].equals(removalEmpty)) {
                this.arr[idx] = comp;
                break;
            }
            i++;
        }
        inserted++;
    }

    public int findIndex(String key) {
        key = key.toUpperCase();

        int start = hashOne(key);
        int i = 0;
        int offset = hashTwo(key);
        while (i < arr.length) {
            int idx = (start + i * offset) % arr.length;
            String val = this.arr[idx];
            if (val == null) {
                return -1;
            }
            if (val.equals(key)) {
                return idx;
            }
            i++;
        }
        return -1;
    }

    public String get(int bucket) {
        if (bucket < 0) {
            return null;
        }
        return this.arr[bucket];
    }

    // alias of findIndex
    public int find(String key) {
        return this.findIndex(key);
    }

    public String remove(String key) {
        key = key.toUpperCase();

        int bucket = findIndex(key);
        if (bucket < 0) {
            System.out.println(key + " was not found!");
            return null;
        }
        String val = this.arr[bucket];
        this.arr[bucket] = removalEmpty;
        inserted--;
        return val;
    }

    public void resize() {
        String[] oldArr = arr;
        inserted = 0;
        arr = new String[this.arr.length * 2];

        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != null && !oldArr[i].equals(removalEmpty)) {
                insert(oldArr[i]);
            }
        }

        System.out.println("Resized to " + arr.length + "!");
    }
}