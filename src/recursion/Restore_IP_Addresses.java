package recursion;
import java.util.ArrayList;
import java.util.List;
public class Restore_IP_Addresses {
    public static List<String> generateIPAddress(String s) {
        // Write your code here!
        List<String> result = new ArrayList<>();
        if(s.length()<4 || s.length()>12 )
            return result;

        backtrack(s,0,new ArrayList<>(),result);

        return result;

    }

    public static void backtrack(String s, int start, List<String> cur, List<String> result){

        if(cur.size()==4 && start==s.length()){
            result.add(String.join(".", cur));
            return;
        }

        for(int i=1;i<=3;i++){
            if(start + i>s.length())
                break;

            String seg = s.substring(start,start+i);

            if(isValid(seg)){
                cur.add(seg);
                backtrack(s,start+i,cur,result);
                cur.remove(cur.size()-1);
            }

        }
    }

    public static boolean isValid(String segment){
        if (segment == null || segment.length() == 0 || segment.length() > 3) {
            return false;
        }
        // Segment should not have leading zeros unless it's "0"
        if (segment.charAt(0) == '0' && segment.length() > 1) {
            return false;
        }
        // Segment should be a number between 0 and 255
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        String s = new String("23579");
        List<String> ans = generateIPAddress(s);
        for (String an : ans) {
            System.out.println(an);
        }
    }

}
