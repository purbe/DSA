package com.sort;

import java.util.*;

public class RelativeSorting {

    public static List<Integer> relativeSorting(List<Integer> arr, List<Integer> brr, int n, int m) {
        // Step 1: Count occurrences of elements in arr
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Place elements from brr in order
        for (int num : brr) {
            if (frequencyMap.containsKey(num)) {
                int count = frequencyMap.get(num);
                for (int i = 0; i < count; i++) {
                    result.add(num);
                }
                frequencyMap.remove(num); // Remove after placing
            }
        }

        // Step 3: Collect remaining elements, sort, and append
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(entry.getKey());
            }
        }
        Collections.sort(remaining); // Sort remaining elements

        // Append sorted remaining elements
        result.addAll(remaining);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8);
        List<Integer> brr = Arrays.asList(2, 1, 8, 3);

        List<Integer> sortedArr = relativeSorting(arr, brr, arr.size(), brr.size());

        System.out.println("After Relative Sorting: " + sortedArr);
    }
}
