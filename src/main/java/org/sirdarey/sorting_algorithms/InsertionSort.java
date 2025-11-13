package org.sirdarey.sorting_algorithms;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        /*
         * 1. L.H.S is sorted, R.H.S is unsorted
         * 2. Pick from R.H.S and insert into correct position in L.H.S
         * 3. Time Complexity: O(n^2); Space Complexity: O(1)
         * 4. Stable
         * 5. Efficient [O(n)] for small data sets and mostly sorted arrays
         */

        for (int i=1; i<array.length; i++) {
            int j = i - 1, key = array[i];
            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}