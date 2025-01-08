package recursion;
import java.util.List;
import java.util.ArrayList;
public class PrintSeries {

    public static void series(int n,int k, List<Integer> ans){
        ans.add(n);

        if(n<0){
            return;
        }

        series(n-k,k,ans);
        ans.add(n);

    }
    public static List<Integer> printSeries(int n, int k) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();

        series(n,k,ans);

        return ans;
    }

    public static void main (String arg[]){
        System.out.println(printSeries(5,2)+"");
        System.out.println(printSeries(19,6)+"");


    }
}
