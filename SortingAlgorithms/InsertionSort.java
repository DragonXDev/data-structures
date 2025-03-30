package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    private static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            while (j > 0 && numbers[j] < numbers[j - 1]) {

                int temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };

        System.out.println("UNSORTED: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("SORTED: " + Arrays.toString(numbers));
    }
}