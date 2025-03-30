package HashTables.Demos;

public class QuadraticProbingHashTable extends OpenAddressingHashTable {
    private int c1;
    private int c2;

    public QuadraticProbingHashTable(int c1, int c2, int initialCapacity) {
        super(initialCapacity);
        this.c1 = c1;
        this.c2 = c2;
    }

    public QuadraticProbingHashTable() {
        // Initialize with c1=1, c2=1, and initialCapacity=11
        this(1, 1, 11);
    }

    // Returns the bucket index for the specified key and i value using the
    // quadratic probing sequence.
    @Override
    protected int probe(Object key, int i) {
        return (hash(key) + c1 * i + c2 * i * i) % table.length;
    }
}
