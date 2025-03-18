package sorting_algorithms;

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;
        int[] mergedNumbers = new int[mergedSize];

        int mergePos = 0;
        int leftPos = i;
        int rightPos = j + 1;

        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    private static void mergeSort(int[] numbers, int i, int k) {
        int j = 0;

        if (i < k) {
            j = (i + k) / 2;

            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 61, 76, 19, 4, 94, 32, 27, 83, 58 };

        System.out.println("UNSORTED: " + Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("SORTED:   " + Arrays.toString(numbers));
    }
}