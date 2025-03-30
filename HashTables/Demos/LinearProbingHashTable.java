package HashTables.Demos;

public class LinearProbingHashTable extends OpenAddressingHashTable {
    public LinearProbingHashTable(int initialCapacity) {
        super(initialCapacity);
    }

    public LinearProbingHashTable() {
        // Initialize with an initial capacity of 11
        this(11);
    }

    // Returns the bucket index for the specified key and i value using the
    // linear probing sequence.
    @Override
    protected int probe(Object key, int i) {
        return (hash(key) + i) % table.length;
    }
}
