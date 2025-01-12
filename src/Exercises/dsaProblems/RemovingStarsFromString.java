package Exercises.dsaProblems;

import java.util.Stack;

public class RemovingStarsFromString {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
    public static String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        char[] c = s.toCharArray();
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='*'){
                stk.pop();
            }
            else{
                stk.push(c[i]);
            }
        }
        while (!stk.isEmpty()){
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
}
