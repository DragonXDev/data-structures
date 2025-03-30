package HashTables.BirdCatalogueHashTable;

public class BirdCatalogue {
    private Bird[] table;
    private int length;
    private double inserted;
    private int R;
    private Bird start;

    public BirdCatalogue() {
        table = new Bird[2048];
        length = 2048;
        R = 11;
        start = null;
        inserted = 0;
    }

    public int hashOne(int key) {
        return key % length;
    }

    public int hashTwo(int key) {
        int square = key * key;
        int shift = (32 - R) / 2;
        int shiftedBits = square >> shift;
        shiftedBits = shiftedBits & (Integer.MAX_VALUE >> (32 - R - 1));
        return shiftedBits % length;
    }

    private double loadFactor() {
        return ((double) inserted) / length;
    }

    public void _insert(Bird newBird, Bird root) {
        if (newBird == root) {
            resize();
            insert(newBird);
            return;
        }
        if (root == null) {
            inserted++;
            if (loadFactor() > 0.5) {
                resize();
            }
            root = newBird;
        }

        int h1i = this.hashOne(newBird.hashCode());
        int h2i = this.hashTwo(newBird.hashCode());
        if (!(table[h1i] != null)) {
            table[h1i] = newBird;
            return;
        }
        if (!(table[h2i] != null)) {
            table[h2i] = newBird;
            return;
        }
        Bird oldBird = table[h1i];
        table[h1i] = newBird;
        _insert(oldBird, root);
    }

    public void insert(Bird bird) {
        _insert(bird, null);
    }

    public int search(int key) {
        int bucket1 = hashOne(key);

        if (table[bucket1] != null) {
            if (table[bucket1].hashCode() == key) {
                return bucket1;
            }
        }
        int bucket2 = hashTwo(key);
        if (table[bucket2] != null) {
            if (table[bucket2].hashCode() == key) {
                return bucket2;
            }
        }
        return -1;
    }

    public Bird get(int key) {
        int bucket = search(key);
        if (bucket == -1) {
            return null;
        }
        return table[bucket];
    }

    public Bird remove(int key) {
        int bucket = search(key);
        Bird old;
        if (bucket == -1) {
            return null;
        } else {
            old = table[bucket];
            table[bucket] = null;
        }
        return old;
    }

    public void resize() {
        int oldLength = length;
        this.length = length * 2;
        Bird[] arrCopy = table;
        table = new Bird[length];
        for (int i = 0; i < oldLength; i++) {
            if (arrCopy[i] == null) {
                continue;
            } else {
                insert(arrCopy[i]);
            }
        }
        System.out.println("Resizing!");
    }

}