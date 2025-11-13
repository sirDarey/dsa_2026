package org.sirdarey.sorting_algorithms;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        /*
         * 1. Repeatedly swap adjacent elements if they are in wrong order
         * 2. Time Complexity: O(n^2); Space Complexity: O(1)
         * 3. Stable
         * 4. After each inner loop iteration, we move the biggest values to the end of the array
         */

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}