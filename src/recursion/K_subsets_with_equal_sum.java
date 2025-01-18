package recursion;
import java.util.Arrays;
public class K_subsets_with_equal_sum {
    static boolean splitArray(int arr[], int k) {
        // WRITE YOUR CODE HERE
        int totalsum = 0;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            totalsum += arr[i];
        }
        if (totalsum % k != 0) {
            return false;
        }
        int targetsum = totalsum / k;

        Arrays.sort(arr);
        int[] reversedArr = new int[n];
        for (int i = 0; i < n; i++) {
            reversedArr[i] = arr[n - 1 - i];
        }

        // If the largest number is greater than the target sum, return false
        if (reversedArr[0] > targetsum) {
            return false;
        }


        return backtarck(reversedArr, k, targetsum, 0, 0, visited);

    }

    public static boolean backtarck(int arr[], int k, int targetsum, int currentsum, int start, boolean[] visited) {

        if (k == 0)
            return true;

        if (currentsum == targetsum)
            return backtarck(arr, k - 1, targetsum, 0, 0, visited);


        for (int i = start; i < arr.length; i++) {

            if (visited[i] || currentsum + arr[i] > targetsum) {
                continue;
            }

            visited[i] = true;
            if (backtarck(arr, k, targetsum, currentsum + arr[i], i + 1, visited)) {
                return true;
            }

            visited[i] = false;

        }

        return false;

    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        System.out.println(splitArray(arr, k) + "");
    }
}
