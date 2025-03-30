package HashTables.Demos;

public class ChainingHashTable extends HashTable {
    private ChainingHashTableItem[] table;

    public ChainingHashTable(int initialCapacity) {
        table = new ChainingHashTableItem[initialCapacity];
    }

    public ChainingHashTable() {
        // Initialize with an initial capacity of 11
        this(11);
    }

    // Inserts the specified key/value pair. If the key already exists, the
    // corresponding value is updated. If inserted or updated, true is returned.
    // If not inserted, then false is returned.
    @Override
    public boolean insert(Object key, Object value) {
        // Hash the key to get the bucket index
        int bucketIndex = hash(key) % table.length;

        // Traverse the linked list, searching for the key. If the key exists in
        // an item, the value is replaced. Otherwise a new item is appended.
        ChainingHashTableItem item = table[bucketIndex];
        ChainingHashTableItem previous = null;
        while (item != null) {
            if (key.equals(item.key)) {
                item.value = value;
                return true;
            }

            previous = item;
            item = item.next;
        }

        // Append to the linked list
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new ChainingHashTableItem(key, value);
        } else {
            previous.next = new ChainingHashTableItem(key, value);
        }
        return true;
    }

    // Searches for the specified key. If found, the key/value pair is removed
    // from the hash table and true is returned. If not found, false is returned.
    @Override
    public boolean remove(Object key) {
        // Hash the key to get the bucket index
        int bucketIndex = hash(key) % table.length;

        // Search the bucket's linked list for the key
        ChainingHashTableItem item = table[bucketIndex];
        ChainingHashTableItem previous = null;
        while (item != null) {
            if (key.equals(item.key)) {
                if (previous == null) {
                    // Remove linked list's first item
                    table[bucketIndex] = item.next;
                } else {
                    previous.next = item.next;
                }
                return true;
            }

            previous = item;
            item = item.next;
        }

        return false; // key not found
    }

    // Searches for the key, returning the corresponding value if found, null if
    // not found.
    @Override
    public Object search(Object key) {
        // Hash the key to get the bucket index
        int bucketIndex = hash(key) % table.length;

        // Search the bucket's linked list for the key
        ChainingHashTableItem item = table[bucketIndex];
        while (item != null) {
            if (key.equals(item.key)) {
                return item.value;
            }
            item = item.next;
        }

        return null; // key not found
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < table.length; i++) {
            result += (i + ": ");

            if (table[i] == null) {
                result += "(empty)\n";
            } else {
                ChainingHashTableItem item = table[i];
                while (item != null) {
                    result += String.format("%s, %s --> ", item.key.toString(),
                            item.value.toString());
                    item = item.next;
                }
                result += "\n";
            }
        }
        return result;
    }
}
