package Exercises.dsaProblems;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElementDifference {
    public static void main(String[] args) {
        int[] a = new int[]{2,1,-1,3,4};
        int[] res = new int[a.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!stk.isEmpty() && a[i] > a[stk.peek()] ){
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = -1;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
