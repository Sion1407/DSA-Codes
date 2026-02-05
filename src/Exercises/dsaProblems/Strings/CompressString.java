package Exercises.dsaProblems.Strings;

import java.util.Stack;

public class CompressString {
    public static void main(String[] args) {
        String s = "ABABCABABCD";
//        a4v
//        res = "ABCD"
        Stack<String> stk = new Stack<>();
        int n = s.length();
        int i =0, j = n/2;
        while (j>0){
            int mid = j;
            for(i = 0;i<mid && s.charAt(i)==s.charAt(j);i++,j++);
            if (i==mid){
                stk.push(s.substring(j,n));
                stk.push(s.substring(0,i));
                n = mid;
                j = n/2;
            }
            else{
                j=mid-1;
            }
        }
        String newS = "";
        while (!stk.isEmpty()){
            newS=newS+"*"+stk.peek();
            stk.pop();
        }
        System.out.println(newS);
    }
}
