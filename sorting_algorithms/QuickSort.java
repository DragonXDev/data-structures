package sorting_algorithms;

import java.util.Arrays;

public class QuickSort {
    private static int partition(int[] numbers, int startIndex, int endIndex) {
        int pivot = numbers[startIndex + (endIndex - startIndex) / 2];
        int low = startIndex;
        int high = endIndex;

        while (low <= high) {
            while (numbers[low] < pivot) {
                low++;
            }
            while (numbers[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = numbers[low];
                numbers[low] = numbers[high];
                numbers[high] = temp;
                low++;
                high--;
            }
        }
        return high;
    }

    public static void quicksort(int[] numbers, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int partitionIndex = partition(numbers, startIndex, endIndex);
        quicksort(numbers, startIndex, partitionIndex);
        quicksort(numbers, partitionIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] numbers = { 12, 18, 3, 7, 32, 14, 91, 16, 8, 57 };
        quicksort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}
