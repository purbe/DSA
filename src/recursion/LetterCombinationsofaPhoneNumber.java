package recursion;
import java.util.ArrayList;
public class LetterCombinationsofaPhoneNumber {
    public static ArrayList<String> combinations(String s){

        // Write your code here
        String [] mapping= {
                "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        ArrayList<String> result = new ArrayList<>();

        generate(s,0,"",result,mapping);

        return result;
    }

    public static void generate(String s, int index,String current,ArrayList<String> result, String[] mapping){

        if(index==s.length())
        {
            result.add(current);
            return;
        }

        String letters = mapping[s.charAt(index)-'0'];

        for(char c: letters.toCharArray()){
            generate(s, index+1, current+c, result, mapping);
        }

    }

    public static void main(String[] args) {
        String digits = "234";
        ArrayList<String> combinations = combinations(digits);

        System.out.println("Combinations:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
