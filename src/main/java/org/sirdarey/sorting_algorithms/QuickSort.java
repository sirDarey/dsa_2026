package org.sirdarey.sorting_algorithms;

public class QuickSort {

    public static void mergeSort(int[] mergeSortArray, int left, int right) {
        /*
         * 1. Divide and Conquer
         * 2. Time Complexity: O(n log n); Space Complexity: O(n)
         * 3. Stable
         */
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // Recursively sort first and second halves
        mergeSort(mergeSortArray, left, mid);
        mergeSort(mergeSortArray, mid + 1, right);

        // Merge the sorted halves
        merge(mergeSortArray, left, mid, right);
    }

    private static void merge(int[] mergeSortArray, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(mergeSortArray, left, L, 0, n1);
        System.arraycopy(mergeSortArray, mid + 1, R, 0, n2);

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int p = 0, q = 0;

        // Initial index of merged subarray
        int k = left;
        while (p < n1 && q < n2) {
            if (L[p] <= R[q]) {
                mergeSortArray[k++] = L[p++];
            } else {
                mergeSortArray[k++] = R[q++];
            }
        }

        // Copy remaining elements of L[] if any
        while (p < n1) {
            mergeSortArray[k++] = L[p++];
        }

        // Copy remaining elements of R[] if any
        while (q < n2) {
            mergeSortArray[k++] = R[q++];
        }
    }
}