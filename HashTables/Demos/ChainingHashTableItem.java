package HashTables.Demos;

class ChainingHashTableItem {
    public Object key;
    public Object value;
    public ChainingHashTableItem next;

    ChainingHashTableItem(Object itemKey, Object itemValue) {
        key = itemKey;
        value = itemValue;
        next = null;
    }
}
