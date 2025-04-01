package Heaps.MinHeap;

public class MyMinHeap {
    private String[] heap;
    private int size;

    public MyMinHeap() {
        size = 0;
        heap = new String[2];
    }

    public MyMinHeap(int length) {
        size = 0;
        heap = new String[length];
    }

    public String peek() {
        return heap[0] == null ? "Empty!" : heap[0];
    }

    public void insert(String add) {
        if (size == heap.length) {
            resize();
        }

        heap[size++] = add;
        percolateUp(size - 1);

        System.out.println(add + " was inserted!");
        printHeap();
    }

    public String remove() {
        String rem = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        percolateDown(0);

        System.out.println(rem + " was removed!");
        printHeap();

        return rem;
    }

    private void percolateUp(int index) {
        while (index > 0) {

            int parentIndex = (index - 1) / 2;

            if (heap[index].compareTo(heap[parentIndex]) >= 0) {
                return;
            } else {
                String temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;

                System.out.println("Percolating up: swapped " + heap[index] + " with " + temp);

                index = parentIndex;
            }
        }
    }

    private void percolateDown(int index) {
        int childIndex = 2 * index + 1;
        String value = heap[index];

        while (childIndex < size) {

            String maxValue = value;
            int maxIndex = -1;
            int i = 0;
            while (i < 2 && i + childIndex < size) {
                if (heap[i + childIndex].compareTo(maxValue) < 0) {
                    maxValue = heap[i + childIndex];
                    maxIndex = i + childIndex;
                }
                i++;
            }

            if (maxValue == value) {
                return;
            } else {
                String temp = heap[index];
                heap[index] = heap[maxIndex];
                heap[maxIndex] = temp;

                System.out.println("Percolating down: swapped " + heap[index] + " with " + temp);

                index = maxIndex;
                childIndex = 2 * index + 1;
            }
        }
    }

    private void printHeap() {
        System.out.print("[");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }

    private void resize() {
        String[] newHeap = new String[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        System.out.println("Resized from " + heap.length + " to " + (heap.length * 2) + "!");
        heap = newHeap;
    }
}