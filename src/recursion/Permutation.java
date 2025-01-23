package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private  void backtrack(int[] nums, int start, List<List<Integer>> result) {
        // Base case: If the start index reaches the end, add the current permutation to the result
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        // Generate permutations by swapping
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // Swap current element with the start element
            backtrack(nums, start + 1, result); // Recurse with the next index
            swap(nums, start, i); // Backtrack (restore original state)
        }
    }

    private  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        List<List<Integer>> permutations = permute(nums);
//
//        System.out.println("All Permutations:");
//        for (List<Integer> permutation : permutations) {
//            System.out.println(permutation);
//        }
        String s = new String("abc");
        List<String> ans = findPermutations(s);
        for (String an : ans) {
            System.out.println(an);
        }
    }
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> result = new ArrayList<>();
        StringBuilder s1 = new StringBuilder(s);

        backtarck(s1,0,result);
        return result;

    }

    public static void backtarck(StringBuilder s, int start, List<String> result){

        if(start==s.length()){
            result.add(s.toString());
            return;
        }

        for(int i= start;i< s.length();i++){
            swap(s,start,i);
            backtarck(s,start+1,result);
            swap(s,i,start);
        }

    }

    public static void swap(StringBuilder s, int start, int i){
        char temp = s.charAt(start);
        s.setCharAt(start, s.charAt(i));
        s.setCharAt(i, temp);
    }
}

