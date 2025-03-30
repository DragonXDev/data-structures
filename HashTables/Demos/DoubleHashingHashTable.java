package HashTables.Demos;

public class DoubleHashingHashTable extends OpenAddressingHashTable {
    public DoubleHashingHashTable(int initialCapacity) {
        super(initialCapacity);
    }

    public DoubleHashingHashTable() {
        // Initialize with an initial capacity of 11
        this(11);
    }

    // The secondary hash function. Many different functions can
    // be used here. The function used here is a common one, with
    // different (usually prime number) constants used where the 7 is.
    private int h2(Object key) {
        return 7 - hash(key) % 7;
    }

    // Returns the bucket index for the specified key and i value using the
    // double hashing probing sequence.
    @Override
    protected int probe(Object key, int i) {
        return (hash(key) + i * h2(key)) % table.length;
    }
}
