package org.sirdarey.sorting_algorithms;

import java.util.Arrays;

import static org.sirdarey.sorting_algorithms.BubbleSort.bubbleSort;
import static org.sirdarey.sorting_algorithms.BucketSort.bucketSort;
import static org.sirdarey.sorting_algorithms.InsertionSort.insertionSort;
import static org.sirdarey.sorting_algorithms.MergeSort.mergeSort;
import static org.sirdarey.sorting_algorithms.QuickSort.quickSort;
import static org.sirdarey.sorting_algorithms.SelectionSort.selectionSort;

public class Main {

    public static void main(String[] args) {

        int [] array = {7, 2, 10, 1, 6, 8, 5, 3, 4, 9};
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

        int [] quickSortArray = Arrays.copyOf(array, array.length);
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        System.out.println("Sorted array using Quick Sort: ");
        printArray(quickSortArray);

        int [] bucketSortArray = Arrays.copyOf(array, array.length);
        bucketSort(bucketSortArray);
        System.out.println("Sorted array using Bucket Sort: ");
        printArray(bucketSortArray);
    }


    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("-----------------------");
    }
}