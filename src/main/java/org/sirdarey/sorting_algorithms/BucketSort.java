package org.sirdarey.sorting_algorithms;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public static void bucketSort(int[] bucketSortArray) {
        /*
         * 1. Split the array into several buckets, sort each bucket individually, then merge them.
         * 2. Time Complexity: Average = O(n + k), Worst = O(n²).
         *    Space Complexity: O(n + k) for standard bucket sort.
         *    where n is the number of elements and k is the number of buckets.
         * 3. Stability depends on the sorting method used inside buckets
         */

        int n = bucketSortArray.length;
        if (n <= 1) return;

        int max = bucketSortArray[0];
        for (int v : bucketSortArray) {
            max = Math.max(max, v);
        }

        int bucketCount = (int) Math.sqrt(n);

        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : bucketSortArray) {
            int bucketIndex = (value * bucketCount) / (max + 1);
            buckets.get(bucketIndex).add(value);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
            for (int num : bucket) {
                bucketSortArray[idx++] = num;
            }
        }
    }


    private static void insertionSort(List<Integer> list) {
        for (int i=1; i<list.size(); i++) {
            int key = list.get(i);
            int j = i-1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
    }
}

/*
 *  [7, 2, 10, 1, 6, 8, 5, 3, 4, 9]
 *
 * 0 -> 2, 1, 3
 * 1 -> 7, 6, 5, 4
 * 2 -> 10, 8, 9
 *
 * bucketIndex = 2
 * n = 10
 * max = 10
 * bucketCount = 3
 */