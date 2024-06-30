package Exercises.dsaProblems;

import java.util.Stack;

//20. Valid Parentheses
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{')
                stk.push(c);
            else if ((c==')' || c==']' || c=='}') && !stk.isEmpty()) {
                if (stk.peek()=='(' && c==')')
                    stk.pop();
                else if (stk.peek()=='[' && c==']') {
                    stk.pop();
                } else if ( stk.peek()=='{' && c=='}') {
                    stk.pop();
                } else
                    return false;
            }
            else {
                return false;
            }
        }
        if (stk.isEmpty())
            return true;
        return false;

    }
}
