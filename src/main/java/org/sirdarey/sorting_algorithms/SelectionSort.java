package org.sirdarey.sorting_algorithms;

public class SelectionSort {

    public static void selectionSort(int[] selectionSortArray) {
        /*
         * 1. repeatedly find the smallest element and move to the front
         * 2. Time Complexity: O(n^2); Space Complexity: O(1)
         * 3. Not stable
         */

        int n = selectionSortArray.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (selectionSortArray[j] < selectionSortArray[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the element at i
            int temp = selectionSortArray[minIdx];
            selectionSortArray[minIdx] = selectionSortArray[i];
            selectionSortArray[i] = temp;
        }
    }
}