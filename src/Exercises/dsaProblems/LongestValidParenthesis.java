package Exercises.dsaProblems;


import java.util.Stack;

//32. Longest Valid Parenthesis
public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stk =  new Stack<>();
        if (s.isEmpty()) return 0;
        int res = 0;
        char [] chr = s.toCharArray();
        stk.push(-1);
//        stk.push(0);
        for(int i = 0;i < chr.length;i++){
            if (chr[i]==')'){
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }
                res = Math.max(res,i-stk.peek());
            }
            else if (chr[i]=='('){
                stk.push(i);
            }
        }
        return res;

    }
}
