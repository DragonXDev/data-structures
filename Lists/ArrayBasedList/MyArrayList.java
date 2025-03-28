package Lists.ArrayBasedList;

public class MyArrayList {
    int length;
    int size;
    String[] data;

    public MyArrayList(int size) {
        this.size = size;
        data = new String[size];
    }

    public MyArrayList() {
        size = 10;
        data = new String[10];
    }

    public void allocateSize(int newSize) {
        size = newSize;
        String[] newArr = new String[size];

        for (int i = 0; i < length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    public void append(String value) {
        if (length == size) {
            allocateSize(length * 2);
        }
        data[length] = value;
        length++;
    }

    public void prepend(String value) {
        if (length == size) {
            allocateSize(length * 2);
        }
        for (int i = length; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = value;
        length++;
    }

    public void shiftRight(int index) {
        if (length == size) {
            allocateSize(length * 2);
        }
        for (int i = length - 1; i >= index; i--) {
            data[i] = data[i - 1];
        }
        length++;
    }

    public void insert(int index, String value) {
        if (index > length || index < 0) {
            System.out.println("ERROR: Out of bounds index!");
            return;
        }
        if (length == size) {
            allocateSize(length * 2);
        }
        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        length++;
    }

    public String remove(int index) {
        String rem = data[index];
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
        return rem;
    }

    public String remove(String value) {
        for (int i = 0; i < length; i++) {
            if (data[i] != null) {
                if (data[i].equals(value)) {
                    return remove(i);
                }
            }
        }
        return "";
    }

    public int size() {
        return length;
    }

    public String get(int index) {
        if (index > length - 1 || index < 0) {
            System.out.println("ERROR: Out of bounds index!");
            return "";
        }
        return data[index];
    }

    public void set(int index, String value) {
        if (index > length - 1 || index < 0) {
            System.out.println("ERROR: Out of bounds index!");
            return;
        }
        data[index] = value;
    }

    public int indexOf(String value) {
        for (int i = 0; i < length; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String msg = "[";
        for (int i = 0; i < length; i++) {
            msg += data[i];
            if (i != length - 1) {
                msg += ", ";
            }
        }
        msg += "]";
        return msg;
    }

}