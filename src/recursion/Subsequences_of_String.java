package recursion;
import java.util.List;
import java.util.ArrayList;
public class Subsequences_of_String {
    public static ArrayList<String> subsequences(String str) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        backtrack(str,0,"",result);

        return result;
    }

    public static void backtrack(String s, int start,String curr,ArrayList<String> result){
        if( start == s.length())
        {
            if(!curr.isEmpty()) // exclude the empty string
                result.add(curr);

            return;
        }

        backtrack(s,start+1,curr + s.charAt(start),result);

        backtrack(s,start+1,curr,result);

    }

    public static void main(String[] arg) {
        System.out.println(subsequences("abc"));
    }
}
