package com.sort;
import java.util.* ;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class SortAnArrayAccordingToTheCountOfSet_Bits {
    public static void sortSetBitsCount(ArrayList<Integer> arr, int size) {
        // Write your code here

        //Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Stable sorting based on set bit count (Descending order)
        // Arrays.sort(arr, Comparator.comparingInt(Integer::bitCount).reversed());

        // Convert back to int[]
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = boxedArr[i];
        // }
        Collections.sort(arr, Comparator.comparingInt(Integer::bitCount).reversed());
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 10, 8, 7));

        System.out.println("Before Sorting: " + arr);
        sortSetBitsCount(arr, arr.size());
        System.out.println("After Sorting by Set Bits: " + arr);
    }
}
