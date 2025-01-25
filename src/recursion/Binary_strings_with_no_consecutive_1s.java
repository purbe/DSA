package recursion;
import java.util.ArrayList;
import java.util.List;

public class Binary_strings_with_no_consecutive_1s {

    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> sol = new ArrayList<>();
        recur(N, "",sol);
        return sol;

    }

    public static void recur(int N, String s, List<String> sol){

        if(s.length()==N){
            sol.add(s.toString());
            return;
        }

        recur(N,s+"0",sol);
        if(s.length()==0||s.charAt(s.length()-1)!='1'){
            recur(N, s+"1", sol);
        }
    }

    public static  void main (String[] arg){

        System.out.println(generateString(4)+"");
    }
}
