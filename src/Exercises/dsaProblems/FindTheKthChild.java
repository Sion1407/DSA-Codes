package Exercises.dsaProblems;

//3178. Find the Child Who Has the Ball After K Seconds

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindTheKthChild {
    public static void main(String[] args) {
        System.out.println(numberOfChild(2,1));
    }

    public static int numberOfChild(int n, int k) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        k--;
//        if (k==0) return st.pop();
        int temp = 1;
        while (k>=0){
            if (temp==n){
                while (st.size()!=1 && k>=0){
                    st.pop();
                    temp--;
                    k--;
                }
            }
            else {
                st.push(temp);
                k--; temp++;
            }
        }
        return st.pop();
    }
}
