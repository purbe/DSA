package recursion;
import java.util.ArrayList;
import java.util.Arrays;

 public class TOH {

     public static void TOH1(int src, int helper, int dest, ArrayList<ArrayList<Integer>> ans, int n){

         if(n==1){
             ArrayList<Integer> move = new ArrayList<>(Arrays.asList(src,dest));
             ans.add(move);
             return;

         }
         TOH1(src,dest,helper,ans,n-1);
         ArrayList<Integer> move = new ArrayList<>(Arrays.asList(src,dest));
         ans.add(move);
         TOH1(helper,src,dest,ans,n-1);

     }
     public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n){
         ArrayList < ArrayList<Integer>> ans = new ArrayList<>();
         TOH1(1,2,3,ans,n);
         return ans;
    }

    public static void main (String arg[]){
        System.out.printf(towerOfHanoi(1)+"");
        System.out.printf(towerOfHanoi(3)+"");
    }

}


