package Exercises.dsaProblems;

//22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
         helper(res, 0,0,"",n);
         return res;
    }
    private static void helper(List<String> res, int left, int right, String s,int n){
        if (s.length()==n*2){
            res.add(s);
            return;
        }
        if (left<n){
            helper(res,left+1,right,s+"(",n);
        }
        if (right<left){
            helper(res,left,right+1,s+")",n);
        }
    }
}
