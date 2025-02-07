package com.sort;
import java.util.*;

public class Sort_a_half_sorted_array {
    public static void sortHalfSorted(ArrayList<Integer> arr) {
        int n = arr.size();
        int mid = n / 2;

        // Left and right halves
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, n));

        // Merge the two sorted halves
        ArrayList<Integer> merged = mergeSortedLists(left, right);

        // Copy back the result to arr
        for (int i = 0; i < n; i++) {
            arr.set(i, merged.get(i));
        }
    }

    private static ArrayList<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 2, 3, 6));

        System.out.println("Before Sorting: " + arr);
        sortHalfSorted(arr);
        System.out.println("After Sorting by Set Bits: " + arr);
    }
}
