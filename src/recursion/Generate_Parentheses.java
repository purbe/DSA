package recursion;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: If the current string is of length 2 * n, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if possible
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a closing parenthesis if possible
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Example input
        List<String> result = generateParenthesis(n);

        System.out.println("All combinations of " + n + " pairs of parentheses:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}

