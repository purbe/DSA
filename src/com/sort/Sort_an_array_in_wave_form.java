package com.sort;
import java.util.Arrays;

public class Sort_an_array_in_wave_form {
    public static int[] waveFormArray(int[] arr, int n) {
        // Write your code here.


        for (int i = 0; i < n; i += 2) {
            // Swap with the previous element if needed
            if (i > 0 && arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }

            // Swap with the next element if needed
            if (i < n - 1 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 2};

        System.out.println("Before Sorting: " + Arrays.toString(arr));
        waveFormArray(arr,5);
        System.out.println("After Wave Sorting: " + Arrays.toString(arr));
    }
}
