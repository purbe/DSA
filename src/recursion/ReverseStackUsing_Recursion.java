package recursion;
import java.util.Stack;
public class ReverseStackUsing_Recursion {
    public static void reverseStack(Stack<Integer> stack) {
        // write your code here

        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();

        reverseStack(stack);

        insertBottom(stack,top);

    }

    public static void insertBottom (Stack<Integer> stack, int ele){

        if(stack.isEmpty()){
            stack.push(ele);
            return;
        }

        int top = stack.pop();

        insertBottom(stack, ele);

        stack.push(top);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);
    }

}
