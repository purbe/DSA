package recursion;
import  java.util.ArrayList;
import java.util.List;
public class Sort_By_Kth_Bit {
    public static int[] sortArrayByKBit(int n, int k, int arr[]) {
        List<Integer> zeroBitGroup = new ArrayList<>();
        List<Integer> oneBitGroup = new ArrayList<>();

        // Separate elements into two groups based on K-th bit
        for (int num : arr) {
            if (((num >> (k - 1)) & 1) == 0) {
                zeroBitGroup.add(num); // K-th bit is 0
            } else {
                oneBitGroup.add(num);  // K-th bit is 1
            }
        }

        // Merge both groups while maintaining order
        int index = 0;
        for (int num : zeroBitGroup) {
            arr[index++] = num;
        }
        for (int num : oneBitGroup) {
            arr[index++] = num;
        }

        return arr;
    }

    public static void main (String [] arg){
         int[] arr = {1,2,3,4};
         int [] arr1 = sortArrayByKBit(4,1,arr);

         for(int num : arr1){
             System.out.print(num);
         }

    }
}
