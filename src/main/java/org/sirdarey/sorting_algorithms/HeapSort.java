package org.sirdarey.sorting_algorithms;

public class HeapSort {

    public static void heapSort(int[] arr) {
        /*
         * 1. Builds a max-heap and repeatedly extracts the largest element.
         * 2. Time Complexity:
         *      - Build Heap: O(n)
         *      - Each extraction: O(log n) × n times = O(n log n)
         *    Total: O(n log n)
         * 3. Space Complexity: O(1) — in-place sorting
         * 4. Not stable
         * 5. Works well for large data due to predictable O(n log n)
         */

        int n = arr.length;

        // 1. Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to the end
            swap(arr, 0, i);

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }


    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;          // assume root (i) is largest
        int left = 2 * i + 1;     // left child index
        int right = 2 * i + 2;    // right child index

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than current largest
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
         0  1   2  3  4  5  6  7  8  9
        [10, 9, 8, 4, 6, 7, 5, 3, 1, 2]

swapped = (4, 9)

 *   n = 10
 *   i = 4
 *

 i     heapSize    largest    left   right
 0       10           2         1     2


                   0

           1                2
       3      4         5        6
      7 8   9  10     11  12  13   14

 */