package org.sirdarey;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int [] array = {64, 34, 25, 90, 22, 11, 12};
        System.out.println("\nOriginal array: ");
        printArray(array);

        int [] selectionSortArray = Arrays.copyOf(array, array.length);
        selectionSort(selectionSortArray);
        System.out.println("Sorted array using Selection Sort: ");
        printArray(selectionSortArray);

        int [] bubbleSortArray = Arrays.copyOf(array, array.length);
        bubbleSort(bubbleSortArray);
        System.out.println("Sorted array using Bubble Sort: ");
        printArray(bubbleSortArray);

        int [] insertionSortArray = Arrays.copyOf(array, array.length);
        insertionSort(insertionSortArray);
        System.out.println("Sorted array using Insertion Sort: ");
        printArray(insertionSortArray);

        int [] mergeSortArray = Arrays.copyOf(array, array.length);
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        System.out.println("Sorted array using Merge Sort: ");
        printArray(mergeSortArray);
    }



    private static void selectionSort(int[] selectionSortArray) {
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


    private static void bubbleSort(int[] array) {
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


    private static void insertionSort(int[] array) {
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


    private static void mergeSort(int[] mergeSortArray, int left, int right) {
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


    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("-----------------------");
    }
}