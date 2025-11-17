package org.sirdarey.sorting_algorithms;

public class QuickSort {

    public static void quickSort(int[] quickSortArray, int left, int right) {
        /*
         * 1. Divide and Conquer
         * 2. Find a pivot, move all smaller elements to the left and higher elements, right.
         * 3. Time Complexity: O(n log n); Space Complexity: O(log n) -> Recursive call stack
         * 4. Not Stable
         */
        if (left >= right) return;

        //Find pivot
        int pivot = partition(quickSortArray, left, right);

        // Recursively do quick sort on left and right partitions
        quickSort(quickSortArray, left, pivot-1);
        quickSort(quickSortArray, pivot+1, right);
    }

    private static int partition (int[] quickSortArray, int left, int right) {

        // pivot is most times set to the right element
        int pivot = quickSortArray[right];

        int i = left-1;
        for (int j=left; j<right; j++){
            if (quickSortArray[j] < pivot) {
                swap(quickSortArray, ++i, j);
            }
        }
        swap(quickSortArray, ++i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}