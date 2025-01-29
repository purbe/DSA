package recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Combination_Sum {
    public static List< List < Integer > > combSum(int []ARR, int B) {
        // Write your code here.
        List< List < Integer > > result = new ArrayList<>();
        Arrays.sort(ARR);
        backtrack(ARR,0,B, new ArrayList<>(), result );

        return result;
    }

    public static void backtrack(int []ARR, int index, int target, List<Integer> current,List< List < Integer > > result  ){

        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i= index;i<ARR.length;i++){
            if(ARR[i]>target) break;

            current.add(ARR[i]);
            backtrack(ARR,i,target-ARR[i],current,result);
            current.remove(current.size()-1);

        }

    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> combinations = combSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
