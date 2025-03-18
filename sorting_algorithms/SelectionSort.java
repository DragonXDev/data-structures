package sorting_algorithms;

import java.util.Arrays;

public class SelectionSort {
    private static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {

            int indexSmallest = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[indexSmallest];
            numbers[indexSmallest] = temp;
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };

        System.out.println("UNSORTED: " + Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("SORTED: " + Arrays.toString(numbers));
    }
}