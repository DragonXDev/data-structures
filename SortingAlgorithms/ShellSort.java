package SortingAlgorithms;

import java.util.Arrays;

public class ShellSort {
    private static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
        for (int i = startIndex + gap; i < numbers.length; i += gap) {
            int temp = numbers[i];
            int j = i;
            while (j - gap >= startIndex && numbers[j - gap] > temp) {
                numbers[j] = numbers[j - gap];
                j -= gap;
            }
            numbers[j] = temp;
        }
    }

    public static void shellSort(int[] numbers, int[] gapValues) {
        for (int gap : gapValues) {
            for (int i = 0; i < gap; i++) {
                insertionSortInterleaved(numbers, i, gap);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 55, 99, 87, 54, 31, 17, 28, 18 };
        int[] gapValues = { 4, 2, 1 };
        shellSort(numbers, gapValues);
        System.out.println(Arrays.toString(numbers));
    }
}
