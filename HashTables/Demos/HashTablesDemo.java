package HashTables.Demos;

public class HashTablesDemo {
    public static void main(String[] args) {
        String[] keys = {
                "Los Angeles", "Houston", "Washington",
                "Chicago", "San Francisco", "Dallas",
                "Tokyo", "New York", "Vancouver"
        };
        String[] values = {
                "LAX", "IAH", "IAD",
                "ORD", "SFO", "DAL",
                "NRT", "JFK", "YVR"
        };

        final int initialCapacity = 11;

        // Initialize the four types of hash tables
        HashTable[] tables = {
                new ChainingHashTable(initialCapacity),
                new LinearProbingHashTable(initialCapacity),
                new QuadraticProbingHashTable(1, 1, initialCapacity),
                new DoubleHashingHashTable(initialCapacity)
        };

        // Add the same content to each hash table
        for (int i = 0; i < keys.length; i++) {
            // Insert the item into each hash table
            for (int j = 0; j < tables.length; j++) {
                tables[j].insert(keys[i], values[i]);
            }
        }

        // Print each table's buckets
        String[] tableNames = {
                "Chaining",
                "Linear probing",
                "Quadratic probing",
                "Double hashing"
        };
        for (int j = 0; j < tables.length; j++) {
            System.out.printf("%s: initial table:\n", tableNames[j]);
            System.out.println(tables[j]);
        }

        // Remove the 3 oldest keys from each hash table
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tables.length; j++) {
                tables[j].remove(keys[i]);
            }
        }

        // Print each table's buckets again
        System.out.println();
        for (int j = 0; j < tables.length; j++) {
            System.out.printf("%s after removal:\n", tableNames[j]);
            System.out.println(tables[j]);
        }
    }
}
