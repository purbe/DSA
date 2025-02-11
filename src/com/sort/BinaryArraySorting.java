package com.sort;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryArraySorting {
    public static ArrayList<Integer> sortBinaryArray(ArrayList<Integer> arr, int n) {
        //	Write your code here.
        int zeroCount=0;
        int oneCount = 0;
        ArrayList<Integer> newArr = new ArrayList<>();


        for(int i=0;i<n;i++){
            if(arr.get(i)==0){
                zeroCount+=1;
            }
            else oneCount+=1;
        }

        for(int i=0;i<zeroCount;i++ ){
            newArr.add(0);
        }
        while(oneCount!=0){
            newArr.add(1);
            oneCount--;
        }

        return newArr;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0));

        System.out.println("Before Sorting: " + arr);

        System.out.println("After Sorting by Set Bits: " + sortBinaryArray(arr,5));
    }
}
