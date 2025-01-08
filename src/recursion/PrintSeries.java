package recursion;
import java.util.List;
import java.util.ArrayList;
public class PrintSeries {
    public static int dcr(int n, int k, List<Integer> ans){
        if(n==0||n<0){
            ans.add(n);
            return n;
        }
        ans.add(n);
        return dcr (n-k,k,ans);

    }
    public static void incr(int v,int k, int n, List<Integer> ans){
        if(v>n){

            return;
        }
        ans.add(v);
        incr (v+k,k,n,ans);

    }
    public static List<Integer> printSeries(int n, int k) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();

        int v= dcr(n,k,ans);

        incr(v+k,k,n,ans);

        return ans;
    }

    public static void main (String arg[]){
        System.out.println(printSeries(5,2)+"");
        System.out.println(printSeries(19,6)+"");


    }
}
