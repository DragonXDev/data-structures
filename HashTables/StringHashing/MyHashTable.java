package HashTables.StringHashing;

// This is an alias of MyStringHashTable since one of the test cases
// attempts to resolve the identifier MyHashTable instead of MyStringHashTable
class MyHashTable extends MyStringHashTable {
    MyHashTable() {
        super();
    }

    MyHashTable(int length) {
        super(length);
    }
}